package academia.com.br.academia;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class CronometroActivity extends AppCompatActivity {


    final boolean[] isClickPause = {false};
    final long[] tempoQuandoParado = {0};


    final Chronometer cronometro = (Chronometer) findViewById(R.id.chronometerTelaCronometro);

    Button btIniciar = (Button) findViewById(R.id.buttonCronometroIniciar);
    Button btParar = (Button) findViewById(R.id.buttonCronometroParar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);
        buttonCronometroIniciar();
        buttonCronometroParar();
    }

    private void buttonCronometroParar() {

        btParar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                cronometro.stop();
                cronometro.setText("Total: (00:00)");
                tempoQuandoParado[0] = 0;
            }
        });

    }

    public void buttonCronometroIniciar(){


        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(isClickPause[0]){
                    cronometro.setBase(SystemClock.elapsedRealtime() + tempoQuandoParado[0]);
                    cronometro.start();
                    tempoQuandoParado[0] = 0;
                    isClickPause[0] = false;
                }
                else{
                    cronometro.setBase(SystemClock.elapsedRealtime());
                    cronometro.start();
                    tempoQuandoParado[0] = 0;
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cronometro, menu);
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
