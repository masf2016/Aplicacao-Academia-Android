package academia.com.br.academia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalheTreinoActivity extends AppCompatActivity {

    private TextView title;
    private TextView dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_treino);

        title = (TextView) findViewById(R.id.title_data);
        String titleText = getIntent().getExtras().getString("title");
        title.setText(titleText);

        dados = (TextView) findViewById(R.id.text_treino);
        dados.setText(getTextByDay(titleText));
    }

    private String getTextByDay(String dia) {
        String toReturn = null;

        if (dia.equalsIgnoreCase("SEGUNDA")) {

            toReturn = getString(R.string.treino_segunda);

            } else if (dia.equalsIgnoreCase("TERÇA")) {

                toReturn = getString(R.string.treino_terca);

                } else if (dia.equalsIgnoreCase("QUARTA")) {

                    toReturn = getString(R.string.treino_quarta);

                        } else if (dia.equalsIgnoreCase("QUINTA")) {

                            toReturn = getString(R.string.treino_quinta);

                             } else if (dia.equalsIgnoreCase("SEXTA")) {

                                toReturn = getString(R.string.treino_sexta);

        }

        return toReturn;

    }

}
