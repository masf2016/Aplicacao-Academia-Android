package academia.com.br.academia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DietaActivity extends AppCompatActivity {

    private Button voltar;

    private Button buttonSegunda;
    private Button buttonTerca;
    private Button buttonQuarta;
    private Button buttonQuinta;
    private Button buttonSexta;
    private Button buttonSabado;
    private Button buttonDomingo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);

        buttonSegunda = (Button) findViewById(R.id.buttonSegunda);
        buttonSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaCadapioPorDia(R.string.dietaTelaButtonSegunda);
            }
        });

        buttonTerca = (Button) findViewById(R.id.buttonTerca);
        buttonTerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaCadapioPorDia(R.string.dietaTelaButtonTerca);
            }
        });

        buttonQuarta = (Button) findViewById(R.id.buttonQuarta);
        buttonQuarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaCadapioPorDia(R.string.dietaTelaButtonQuarta);
            }
        });

        buttonQuinta = (Button) findViewById(R.id.buttonQuinta);
        buttonQuinta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaCadapioPorDia(R.string.dietaTelaButtonQuinta);
            }
        });

        buttonSexta = (Button) findViewById(R.id.buttonSexta);
        buttonSexta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaCadapioPorDia(R.string.dietaTelaButtonSexta);
            }
        });

        buttonSabado = (Button) findViewById(R.id.buttonSabado);
        buttonSabado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaCadapioPorDia(R.string.dietaTelaButtonSabado);
            }
        });

        buttonDomingo = (Button) findViewById(R.id.buttonDomingo);
        buttonDomingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaCadapioPorDia(R.string.dietaTelaButtonDomingo);
            }
        });

        voltar = (Button) findViewById(R.id.buttonVoltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void abrirTelaCadapioPorDia(int dia) {
        Intent intent = new Intent(DietaActivity.this, CardapioActivity.class);
        intent.putExtra("dia", getString(dia));
        startActivity(intent);
    }

}
