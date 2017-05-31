package academia.com.br.academia;

/**
 * Created by mario on 11/11/15.
 */
public class PracaParque {
    public String nomeOficialEquiUrbano;
    public String tipoEquiUrbano;
    public String areaEquiUrbano;
    public String enderecoEquiUrbano;
    public String bairroEquiUrbano;

    public PracaParque (){

    }
    public PracaParque(String nomeOficialEquiUrbano, String tipoEquiUrbano, String areaEquiUrbano,
                       String enderecoEquiUrbano, String bairroEquiUrbano){

        this.nomeOficialEquiUrbano = nomeOficialEquiUrbano;
        this.tipoEquiUrbano = tipoEquiUrbano;
        this.areaEquiUrbano = areaEquiUrbano;
        this.enderecoEquiUrbano = enderecoEquiUrbano;
        this.bairroEquiUrbano = bairroEquiUrbano;

    }
    @Override
    public String toString(){
        return nomeOficialEquiUrbano;
    }

}
