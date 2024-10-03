package devandroid.aeca.applistacurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import devandroid.aeca.applistacurso.model.Curso;

public class ListaVipDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "listavip.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public ListaVipDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // QUERY SQL para Criar uma tabela

        String sqlTabelaPessoa
                = "CREATE TABLE Pessoa (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "primeiroNome TEXT, " +
                "sobreNome REAL, " +
                "cursoDesejado TEXT, " +
                "telefoneContato TEXT)";

        db.execSQL(sqlTabelaPessoa);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    // Criar métodos para implementar o CRUD
    public void salvarObjeto(String tabela, ContentValues dados) {
        db.insert(tabela, null, dados);
    }

    public List<Combustivel> listarDados() {
        List<Combustivel> lista = new ArrayList<>();

        // Representa um registro que está salvo na tabela Combustivel
        // do Banco de Dados da Aplicação
        Combustivel registro;
        String querySQL = "SELECT * FROM Combustivel";
        cursor = db.rawQuery(querySQL, null);

        if (cursor.moveToFirst()) {
            do {
                registro = new Combustivel();
                registro.setId(cursor.getInt(0));
                registro.setNomeDoCombustivel(cursor.getString(1));
                registro.setPrecoDoCombustivel(cursor.getDouble(2));
                registro.setRecomendacao(cursor.getString(3));

                lista.add(registro);
            }
            while (cursor.moveToNext());
        }
        else {

        }
        return lista;
    }

    public void alterarObjeto(String tabela, ContentValues dados) {
        int id = dados.getAsInteger("id");
        db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)});
    }

    public void deletarObjeto(String tabela, int id) {
        db.delete(tabela, "id=?", new String[]{Integer.toString(id)});
    }

}
