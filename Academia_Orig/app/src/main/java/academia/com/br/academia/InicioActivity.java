package academia.com.br.academia;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText campoLogin;
    private EditText campoSenha;
    private Button buttonFechar;
    private TextView textViewUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        textViewUsuario = (TextView) findViewById(R.id.textViewUsuario);
        buttonFechar = (Button) findViewById(R.id.buttonVoltar);
        buttonFechar.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();

        if((bundle.containsKey("login"))&& (bundle.containsKey("senha"))){
            String usuario = bundle.getString("login");
            textViewUsuario.setText(usuario);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
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

    @Override
    public void onClick(View v) {

       finish();

    }
}
