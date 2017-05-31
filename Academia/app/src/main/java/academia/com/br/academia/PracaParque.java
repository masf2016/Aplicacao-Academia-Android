package academia.com.br.academia;

/**
 * Created by mario on 11/11/15.
 */
public class PracaParque {
    private String tipo;
    private String endereco;
    private String nomeBairro;
    private String nomeOficial;
    private String area;
    private String latitude;
    private String longitude;

    public PracaParque (){

    }
    public PracaParque(String tipo, String endereco, String nomeBairro,
                       String nomeOficial, String area, String latitude, String longitude){

        this.tipo = tipo;
        this.endereco = endereco;
        this.nomeBairro = nomeBairro;
        this.nomeOficial = nomeOficial;
        this.area = area;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getTipo() {


        return tipo;
    }

    public void setTipo(String tipo) {


        this.tipo = tipo;
    }

    public String getEndereco() {


        return endereco;
    }

    public void setEndereco(String endereco) {


        this.endereco = endereco;
    }

    public String getNomeBairro() {

        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {

        this.nomeBairro = nomeBairro;
    }

    public String getNomeOficial() {


        return nomeOficial;
    }

    public void setNomeOficial(String nomeOficial) {

        this.nomeOficial = nomeOficial;

    }

    public String getArea() {


        return area;
    }

    public void setArea(String area) {

        this.area = area;
    }

    public String getLatitude() {

        return latitude;
    }

    public void setLatitude(String latitude) {


        this.latitude = latitude;
    }

    public String getLongitude() {

        return longitude;

    }

    public void setLongitude(String longitude) {

        this.longitude = longitude;

    }
}
