package academia.com.br.academia;

import android.content.Intent;
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


    public void onClick(View v){

    Intent it = new Intent(this,InicioActivity.class);

        it.putExtra("login",campoLogin.getText().toString());
        it.putExtra("senha",campoSenha.getText().toString());

        startActivity(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_academia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
