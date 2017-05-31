package academia.com.br.academia;

import android.content.Intent;
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

    private Button buttonFechar;
    private Button buttonDieta;
    private Button buttonTreino;
    private Button buttonParques;
    private TextView textViewUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        textViewUsuario = (TextView) findViewById(R.id.textViewUsuario);
        buttonFechar = (Button) findViewById(R.id.buttonVoltar);
        buttonFechar.setOnClickListener(this);

        buttonParques = (Button) findViewById(R.id.buttonParque);
        buttonParques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        buttonDieta = (Button) findViewById(R.id.buttonDieta);
        buttonDieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioActivity.this, DietaActivity.class);
                startActivity(intent);
            }
        });

        buttonTreino = (Button) findViewById(R.id.buttonTreino);
        buttonTreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioActivity.this, TreinoActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();

        if(bundle.containsKey("login")){
            String usuario = bundle.getString("login");
            textViewUsuario.setText(usuario);
        }
    }

    @Override
    public void onClick(View v) {
       finish();
    }
}
