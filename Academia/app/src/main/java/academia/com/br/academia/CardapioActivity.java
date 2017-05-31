package academia.com.br.academia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CardapioActivity extends AppCompatActivity {

    private Button inicioTelaButtonSair;
    private Button inicioTelaButtonVoltar;
    private TextView cafe;
    private TextView almoco;
    private TextView janta;
    private TextView lanche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        String dia = getIntent().getExtras().getString("dia");
        cafe = (TextView) findViewById(R.id.textCafe);
        almoco = (TextView) findViewById(R.id.textAlmoco);
        janta = (TextView) findViewById(R.id.textJanta);
        lanche = (TextView) findViewById(R.id.textLanche);

        cafe.setText(getCafeTextByDay(dia));
        almoco.setText(getAlmocoTextByDay(dia));
        janta.setText(getJantaTextByDay(dia));
        lanche.setText(getLancheTextByDay(dia));

        inicioTelaButtonSair = (Button) findViewById(R.id.inicioTelaButtonSair);
        inicioTelaButtonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        inicioTelaButtonVoltar = (Button) findViewById(R.id.inicioTelaButtonVoltar);
        inicioTelaButtonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private String getCafeTextByDay(String dia) {
        String toReturn = null;

        if (dia.equalsIgnoreCase("SEGUNDA")) {

            toReturn = getString(R.string.cafe_segunda);

        } else if (dia.equalsIgnoreCase("TERÇA")) {

            toReturn = getString(R.string.cafe_terca);

        } else if (dia.equalsIgnoreCase("QUARTA")) {

            toReturn = getString(R.string.cafe_quarta);

        } else if (dia.equalsIgnoreCase("QUINTA")) {

            toReturn = getString(R.string.cafe_quinta);

        } else if (dia.equalsIgnoreCase("SEXTA")) {

            toReturn = getString(R.string.cafe_sexta);

        } else if (dia.equalsIgnoreCase("SABADO")) {

            toReturn = getString(R.string.cafe_sabado);

        } else if (dia.equalsIgnoreCase("DOMINGO")) {

            toReturn = getString(R.string.cafe_domingo);
        }

        return toReturn;
    }

    private String getAlmocoTextByDay(String dia) {
        String toReturn = null;

        if (dia.equalsIgnoreCase("SEGUNDA")) {

            toReturn = getString(R.string.almoco_segunda);

        } else if (dia.equalsIgnoreCase("TERÇA")) {

            toReturn = getString(R.string.almoco_terca);

        } else if (dia.equalsIgnoreCase("QUARTA")) {

            toReturn = getString(R.string.almoco_quarta);

        } else if (dia.equalsIgnoreCase("QUINTA")) {

            toReturn = getString(R.string.almoco_quinta);

        } else if (dia.equalsIgnoreCase("SEXTA")) {

            toReturn = getString(R.string.almoco_sexta);

        } else if (dia.equalsIgnoreCase("SABADO")) {

            toReturn = getString(R.string.almoco_sabado);

        } else if (dia.equalsIgnoreCase("DOMINGO")) {

            toReturn = getString(R.string.almoco_domingo);
        }

        return toReturn;
    }

    private String getJantaTextByDay(String dia) {
        String toReturn = null;

        if (dia.equalsIgnoreCase("SEGUNDA")) {

            toReturn = getString(R.string.janta_segunda);

        } else if (dia.equalsIgnoreCase("TERÇA")) {

            toReturn = getString(R.string.janta_terca);

        } else if (dia.equalsIgnoreCase("QUARTA")) {

            toReturn = getString(R.string.janta_quarta);

        } else if (dia.equalsIgnoreCase("QUINTA")) {

            toReturn = getString(R.string.janta_quinta);

        } else if (dia.equalsIgnoreCase("SEXTA")) {

            toReturn = getString(R.string.janta_sexta);

        } else if (dia.equalsIgnoreCase("SABADO")) {

            toReturn = getString(R.string.janta_sabado);

        } else if (dia.equalsIgnoreCase("DOMINGO")) {

            toReturn = getString(R.string.janta_domingo);

        }

        return toReturn;
    }

    private String getLancheTextByDay(String dia) {
        String toReturn = null;

        if (dia.equalsIgnoreCase("SEGUNDA")) {

            toReturn = getString(R.string.lanche_segunda);

        } else if (dia.equalsIgnoreCase("TERÇA")) {

            toReturn = getString(R.string.lanche_terca);

        } else if (dia.equalsIgnoreCase("QUARTA")) {

            toReturn = getString(R.string.lanche_quarta);

        } else if (dia.equalsIgnoreCase("QUINTA")) {

            toReturn = getString(R.string.lanche_quinta);

        } else if (dia.equalsIgnoreCase("SEXTA")) {

            toReturn = getString(R.string.lanche_sexta);

        } else if (dia.equalsIgnoreCase("SABADO")) {

            toReturn = getString(R.string.lanche_sabado);

        } else if (dia.equalsIgnoreCase("DOMINGO")) {

            toReturn = getString(R.string.lanche_domingo);

        }

        return toReturn;

    }

}
