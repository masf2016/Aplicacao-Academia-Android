package academia.com.br.academia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mario on 11/11/15.
 */
public class AcademiaSQLHelper extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "AcademiaBD";
    private static final int VERSAO_DO_BANCO = 1;

    public static final String ACAD_USER_TABELA = "usuarioAcademia";
    public static final String COLUNA_USER_ID = "usuario_id";
    public static final String COLUNA_USER_NOME = "usuario_Nome";
    public static final String COLUNA_USER_SENHA = "usuario_senha";

    public AcademiaSQLHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_DO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE"+ ACAD_USER_TABELA +" ("+
                        COLUNA_USER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        COLUNA_USER_NOME + "TEXT NOT NULL"+
                        COLUNA_USER_SENHA + "TEXT NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
