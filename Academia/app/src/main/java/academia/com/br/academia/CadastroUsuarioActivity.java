package academia.com.br.academia;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroUsuarioActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nome;
    private EditText senha;
    private EditText confirmacaoSenha;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        nome = (EditText) findViewById(R.id.editTextNovoNome);
        senha = (EditText) findViewById(R.id.editTextSenha);
        confirmacaoSenha = (EditText) findViewById(R.id.editTextRedigiteSenha);

        button = (Button) findViewById(R.id.buttonNovoCadastro);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // validação dos dados do usuario

        if (validateNotNullOrEmpty(nome, getString(R.string.erro_nome)) &&  validateNotNullOrEmpty(senha, getString(R.string.erro_senha)) &&
                validateNotNullOrEmpty(confirmacaoSenha, getString(R.string.erro_confirmacao_senha)) && validateEquals(senha, confirmacaoSenha, getString(R.string.erro_nao_iguais))) {

            AcademiaRepositorio repositorio = new AcademiaRepositorio(this);

            if (repositorio.verificaUsuario(nome.getText().toString())) {

                //Gera um alert
                AlertDialog.Builder builder = new AlertDialog.Builder(this).setCancelable(false).setTitle(R.string.alerta).setMessage(R.string.alerta_mensagem_cadastro_e)
                .setPositiveButton(R.string.positive_button,
                     new DialogInterface.OnClickListener() {
                          @Override
                              public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                }
                        });

                AlertDialog dialog = builder.create();

                dialog.show();
            } else {
                UsuarioAcademia academia = new UsuarioAcademia(0, nome.getText().toString(),
                        senha.getText().toString());
                repositorio.salvarUsuario(academia);

                AlertDialog.Builder builder = new AlertDialog.Builder(this).setCancelable(false).setTitle(R.string.alerta).setMessage(R.string.alerta_mensagem_cadastro_s)
                .setPositiveButton(R.string.positive_button,
                      new DialogInterface.OnClickListener() {
                           @Override
                               public void onClick(DialogInterface dialog, int which) {
                                 dialog.dismiss();
                                    finish();
                                 }
                         });

                AlertDialog dialog = builder.create();

                dialog.show();
            }
        }
    }

    private boolean validateNotNullOrEmpty(View view, String message) {

        if (view instanceof EditText) {

            EditText edText = (EditText) view;
            Editable text = edText.getText();

            if (text != null) {

                String strText = text.toString();

                if (!TextUtils.isEmpty(strText)) {

                    return true;

                }
            }
                        // Gera um erro
                        edText.setError(message);
                        edText.setFocusable(true);
                        edText.requestFocus();
                        return false;
        }
        return false;
    }

    private boolean validateEquals(View view, View view2, String message) {

        if (view instanceof EditText && view2 instanceof EditText) {

            EditText edpText = (EditText) view;
            EditText edsText = (EditText) view2;
            Editable ptext = edpText.getText();
            Editable stext = edsText.getText();

            if (ptext != null && stext != null) {

                if (ptext.toString().equals(stext.toString())) {

                    return true;

                }
            }
                        // gera um erro
                        edsText.setError(message);
                        edsText.setFocusable(true);
                        edsText.requestFocus();

                        return false;
        }

        return false;

    }
}
