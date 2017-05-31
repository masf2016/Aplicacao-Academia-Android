package academia.com.br.academia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TreinoActivity extends AppCompatActivity {

    private Button segunda;
    private Button terca;
    private Button quarta;
    private Button quinta;
    private Button sexta;
    private Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino);

        voltar = (Button) findViewById(R.id.buttonTreinoVoltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        segunda = (Button) findViewById(R.id.buttonTreinoSegunda);

        segunda.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                abrirTelaDeTreino(getString(R.string.dietaTelaButtonSegunda));
            }
        });

        terca = (Button) findViewById(R.id.buttonTreinoTerca);

        terca.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                abrirTelaDeTreino(getString(R.string.dietaTelaButtonTerca));
            }
        });

        quarta = (Button) findViewById(R.id.buttonTreinoQuarta);

        quarta.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                abrirTelaDeTreino(getString(R.string.dietaTelaButtonQuarta));
            }
        });

        quinta = (Button) findViewById(R.id.buttonTreinoQuinta);

        quinta.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                abrirTelaDeTreino(getString(R.string.dietaTelaButtonQuinta));
            }
        });

        sexta = (Button) findViewById(R.id.buttonTreinoSexta);

        sexta.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                abrirTelaDeTreino(getString(R.string.dietaTelaButtonSexta));
            }
        });
    }

    private void abrirTelaDeTreino(String title) {

        Intent intent = new Intent(TreinoActivity.this, DetalheTreinoActivity.class);
        intent.putExtra("title", title);
        startActivity(intent);
    }

}
