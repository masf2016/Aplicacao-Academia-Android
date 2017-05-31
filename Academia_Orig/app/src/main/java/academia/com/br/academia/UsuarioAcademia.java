package academia.com.br.academia;

import java.io.Serializable;

/**
 * Created by mario on 11/11/15.
 */
public class UsuarioAcademia implements Serializable{

    public int usuarioId;
    public String usuarioNome;
    public String usuarioSenha;

    public UsuarioAcademia (int usuarioId, String usuarioNome, String usuarioSenha){
        this.usuarioId = usuarioId;
        this.usuarioNome = usuarioNome;
        this.usuarioSenha = usuarioSenha;
    }

    public UsuarioAcademia (String usuarioNome, String usuarioSenha){
        this(0, usuarioNome,usuarioSenha);
   }

    @Override
    public String toString(){
        return usuarioNome;
    }
}
