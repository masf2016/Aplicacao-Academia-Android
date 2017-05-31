package academia.com.br.academia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 11/11/15.
 */
public class AcademiaRepositorio {

    private AcademiaSQLHelper academiaSQLHelper;

    public AcademiaRepositorio(Context context){
        academiaSQLHelper = new AcademiaSQLHelper(context);

    }

    private long inserirUsuario (UsuarioAcademia usuarioAcademia){
        SQLiteDatabase sqLiteDatabase= academiaSQLHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AcademiaSQLHelper.COLUNA_USER_NOME, usuarioAcademia.usuarioNome);
        values.put(AcademiaSQLHelper.COLUNA_USER_SENHA, usuarioAcademia.usuarioSenha);

        long id = sqLiteDatabase.insert(AcademiaSQLHelper.ACAD_USER_TABELA, null,values);

        if(id != -1){
            usuarioAcademia.usuarioId = (int) id;
        }

        sqLiteDatabase.close();

        return id;
    }

    private int atualizarUsuario (UsuarioAcademia usuarioAcademia){

        SQLiteDatabase sqLiteDatabase = academiaSQLHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AcademiaSQLHelper.COLUNA_USER_NOME,usuarioAcademia.usuarioNome);
        values.put(AcademiaSQLHelper.COLUNA_USER_SENHA, usuarioAcademia.usuarioSenha);

        int linhasAfetadas = sqLiteDatabase.update( AcademiaSQLHelper.ACAD_USER_TABELA,values,AcademiaSQLHelper.COLUNA_USER_ID + " = ?",
                new String[]{String.valueOf(usuarioAcademia.usuarioId)});

        sqLiteDatabase.close();

        return linhasAfetadas;

    }

    public void salvarUsuario (UsuarioAcademia usuarioAcademia){

                if (usuarioAcademia.usuarioId == 0){

                     inserirUsuario(usuarioAcademia);

                }else{

                    atualizarUsuario(usuarioAcademia);

                }
    }

    public int excluirUsuario (UsuarioAcademia usuarioAcademia){

                SQLiteDatabase sqLiteDatabase = academiaSQLHelper.getWritableDatabase();

                int linhasAfetadas = sqLiteDatabase.delete(AcademiaSQLHelper.ACAD_USER_TABELA,AcademiaSQLHelper.COLUNA_USER_ID +" = ?",
                        new String[]{String.valueOf(usuarioAcademia.usuarioId)});

                sqLiteDatabase.close();

                return linhasAfetadas;
                //pagina 270
    }

    public UsuarioAcademia buscarUsuario (String nome, String senha){

        SQLiteDatabase sqLiteDatabase = academiaSQLHelper.getReadableDatabase();

        String sql = "SELECT * FROM "+AcademiaSQLHelper.ACAD_USER_TABELA;
        String[] argumentos = null;

        if(nome != null && senha != null){
            sql += " WHERE "+AcademiaSQLHelper.COLUNA_USER_NOME + " = ? AND " + AcademiaSQLHelper.COLUNA_USER_SENHA + " = ?";
            argumentos = new String[]{nome, senha};
        }

        Cursor cursor = sqLiteDatabase.rawQuery(sql,argumentos);

        UsuarioAcademia usuarioAcademias = null;

        while (cursor.moveToNext()){

                int ids = cursor.getInt(cursor.getColumnIndex(AcademiaSQLHelper.COLUNA_USER_ID));

                String nomes  = cursor.getString(cursor.getColumnIndex(AcademiaSQLHelper.COLUNA_USER_NOME));

                String senhas = cursor.getString(cursor.getColumnIndex(AcademiaSQLHelper.COLUNA_USER_SENHA));

                usuarioAcademias = new UsuarioAcademia(ids, nomes, senhas);


            if (usuarioAcademias != null) {
                break;
            }
        }
        cursor.close();

        academiaSQLHelper.close();

        return usuarioAcademias;
    }

    public boolean verificaUsuario(String nome){

        SQLiteDatabase sqLiteDatabase = academiaSQLHelper.getReadableDatabase();

        String sql = "SELECT * FROM "+AcademiaSQLHelper.ACAD_USER_TABELA;

        String[] argumentos = null;

                if(nome != null){

                    sql += " WHERE "+AcademiaSQLHelper.COLUNA_USER_NOME + " = ?";

                    argumentos = new String[]{nome};
                }

        Cursor cursor = sqLiteDatabase.rawQuery(sql,argumentos);

        UsuarioAcademia usuarioAcademias = null;

        while (cursor.moveToNext()){

            int ids = cursor.getInt(cursor.getColumnIndex(AcademiaSQLHelper.COLUNA_USER_ID));

            String nomes  = cursor.getString(cursor.getColumnIndex(AcademiaSQLHelper.COLUNA_USER_NOME));

            String senhas = cursor.getString(cursor.getColumnIndex(AcademiaSQLHelper.COLUNA_USER_SENHA));

            UsuarioAcademia usuarioAcademia = new UsuarioAcademia(ids, nomes, senhas);
        }
        cursor.close();

        academiaSQLHelper.close();

        return usuarioAcademias != null;
    }

    public List <UsuarioAcademia> buscarUsuario (String filtro){

        SQLiteDatabase sqLiteDatabase = academiaSQLHelper.getReadableDatabase();

        String sql = "SELECT * FROM "+AcademiaSQLHelper.ACAD_USER_TABELA;

        String[] argumentos = null;

        if(filtro != null){

            sql += " WHERE "+AcademiaSQLHelper.COLUNA_USER_NOME + " LIKE ?";

            argumentos = new String[]{filtro};
        }

        sql += " ORDER BY "+AcademiaSQLHelper.COLUNA_USER_NOME;

        Cursor cursor = sqLiteDatabase.rawQuery(sql,argumentos);

                List <UsuarioAcademia> usuarioAcademias = new ArrayList<UsuarioAcademia>();

                while (cursor.moveToNext()){

                    int id = cursor.getInt(cursor.getColumnIndex(AcademiaSQLHelper.COLUNA_USER_ID));

                    String nome  = cursor.getString(cursor.getColumnIndex(AcademiaSQLHelper.COLUNA_USER_NOME));

                    String senha = cursor.getString(cursor.getColumnIndex(AcademiaSQLHelper.COLUNA_USER_SENHA));

                    UsuarioAcademia usuarioAcademia = new UsuarioAcademia(id, nome, senha);

                    usuarioAcademias.add(usuarioAcademia);
                }

        cursor.close();

        academiaSQLHelper.close();

        return usuarioAcademias;
    }
}
