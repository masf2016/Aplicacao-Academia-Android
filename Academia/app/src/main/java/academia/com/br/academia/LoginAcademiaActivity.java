package academia.com.br.academia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginAcademiaActivity extends AppCompatActivity implements OnClickListener {

    private EditText campoLogin;
    private EditText campoSenha;
    private Button buttonEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login_academia);

        campoLogin = (EditText) findViewById(R.id.campoLogin);
        campoSenha = (EditText) findViewById(R.id.campoSenha);
        buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
        buttonEntrar.setOnClickListener(this);
    }


    public void onClick(View v) {
        AcademiaRepositorio repositorio = new AcademiaRepositorio(this);
        UsuarioAcademia usuarioAcademia = repositorio.buscarUsuario(campoLogin.getText().toString(),
                campoSenha.getText().toString());

        if (usuarioAcademia != null) {
            Intent it = new Intent(this, InicioActivity.class);
            it.putExtra("login", campoLogin.getText().toString());
            startActivity(it);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this).setCancelable(false).setTitle(R.string.alerta).setMessage(R.string.alerta_mensagem_login)
            .setPositiveButton(R.string.positive_button,
                            new DialogInterface.OnClickListener() {

                        @Override

                        public void onClick(DialogInterface dialog, int which) {


                            dialog.dismiss();
                        }

                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    //chamada do xml responsavel pela criação do Action
        getMenuInflater().inflate(R.menu.menu_login_academia, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_cadastro) {
            Intent intent = new Intent(LoginAcademiaActivity.this, CadastroUsuarioActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
