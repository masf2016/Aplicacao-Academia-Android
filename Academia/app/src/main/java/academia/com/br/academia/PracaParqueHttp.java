package academia.com.br.academia;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 11/11/15.
 */
public class PracaParqueHttp extends AsyncTask<Void, Void, List<PracaParque>> {

    private OnPracaListener listener;
    private Object applicationContext;

    public Object getApplicationContext() {

        return applicationContext;
    }

    public interface OnPracaListener {
        void onPracaListener(List<PracaParque> parques);
    }

    public PracaParqueHttp(OnPracaListener listener) {
        this.listener = listener;
    }

    @Override
    protected List<PracaParque> doInBackground(Void... params) {
        List<PracaParque> parquesList = new ArrayList<PracaParque>();
        HttpURLConnection connection = null;
        //realiza uma tentativa de conexao com o endereço
        try {
            URL url = new URL("http://dados.recife.pe.gov.br/api/action/datastore_search?resource_" +
                    "id=18e58d3b-8096-4bac-bc18-273bacd7d01c&limit=100");

            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int status = connection.getResponseCode();

            String json = null;

            switch (status) {


                case 200:
                  /*Toast.makeText((Context) getApplicationContext(),"Conectado ao servidor",Toast.LENGTH_SHORT).show();
                    break;
                 */
                case 201:

                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {

                        sb.append(line + "\n");

                    }

                    br.close();

                    json = sb.toString();


            }

            if (json != null) {
                parquesList = convertJsonToParques(json);
            }
        } catch (Exception e) {

        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }

        return parquesList;
    }

    @Override
    protected void onPostExecute(List<PracaParque> parques) {
        listener.onPracaListener(parques);
    }

    private List<PracaParque> convertJsonToParques(String json) {
        List<PracaParque> parqueList = new ArrayList<PracaParque>();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject result = object.getJSONObject("result");
            JSONArray array = result.getJSONArray("records");
            if (array != null) {
                for (int i = 0; i < array.length(); i++) {
                    JSONObject newParque = array.getJSONObject(i);
                    PracaParque parque = new PracaParque();
                    parque.setArea(newParque.getString("area"));
                    parque.setNomeBairro(newParque.getString("nome_bairro"));
                    parque.setLongitude(newParque.getString("longitude"));
                    parque.setLatitude(newParque.getString("latitude"));
                    parque.setNomeOficial(newParque.getString("nome_oficial_equip_urbano"));
                    parque.setEndereco(newParque.getString("endereco_equip_urbano"));
                    parque.setTipo(newParque.getString("tipo_equip_urbano"));

                    parqueList.add(parque);
                }
            }


        } catch (Exception e) {
        }
        return parqueList;
    }
}
