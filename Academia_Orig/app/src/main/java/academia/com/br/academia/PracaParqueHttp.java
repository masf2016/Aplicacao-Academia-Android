package academia.com.br.academia;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 11/11/15.
 */
public class PracaParqueHttp {
    public static final String PRACAS_PARQUES_URL_JSON =
            "http://dados.recife.pe.gov.br/storage/f/" +
                    "2015-06-10T17%3A44%3A30.315Z/parques-e-pracas-coordenadas-cartesianas.json";

    private static HttpURLConnection conectar (String urlArquivo) throws IOException{

        final int SEGUNDOS = 1000;
        URL url = new URL(urlArquivo);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setReadTimeout(10 * SEGUNDOS);
        conexao.setReadTimeout(15 * SEGUNDOS);
        conexao.setRequestMethod("GET");
        conexao.setDoInput(true);
        conexao.setDoOutput(false);
        conexao.connect();
        return conexao;

    }

    public static boolean temConexao (Context contexto){

        ConnectivityManager gerenciarConexao = (ConnectivityManager) contexto.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = gerenciarConexao.getActiveNetworkInfo();
        return (info != null && info.isConnected());

    }

    public static List <PracaParque> carregarDadosPracasParques(){
        try{
            HttpURLConnection conexao = conectar(PRACAS_PARQUES_URL_JSON);
            int resposta = conexao.getResponseCode();
                if(resposta == HttpURLConnection.HTTP_OK){
                    InputStream input = conexao.getInputStream();
                    JSONObject json = new JSONObject(bytesParaString(input));
                    return lerDadosPracasParquesJson(json);
                }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String bytesParaString(InputStream input) throws  IOException{

        byte[] buffer = new byte[1024];
        ByteArrayOutputStream buffersLidos = new ByteArrayOutputStream();
        int bytesLidos;

        while ((bytesLidos = input.read(buffer)) != -1){
            buffersLidos.write(buffer,0,bytesLidos);
        }
        return new String (buffersLidos.toByteArray(),"UTF-8");
    }


    public static List<PracaParque> lerDadosPracasParquesJson(JSONObject json) throws JSONException{
        List <PracaParque> listaDePracasParques = new ArrayList<PracaParque>();
        String categoriaAtual;

        JSONArray jsonCampos = json.getJSONArray("campos");
            for(int i =0; i < jsonCampos.length();i++){
                JSONObject jsonDados = jsonCampos.getJSONObject(i);

                PracaParque pracaParque = new PracaParque(
                        jsonDados.getString("nome_oficial_equip_urbano"),
                        jsonDados.getString("tipo_equip_urbano"),
                        jsonDados.getString("area_equip_urbano"),
                        jsonDados.getString("endereco_equip_urbano"),
                        jsonDados.getString("nome_bairro")
                );

                listaDePracasParques.add(pracaParque);
            }
        return listaDePracasParques;

    }
}
