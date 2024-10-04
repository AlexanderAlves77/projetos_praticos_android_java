package devandroid.aeca.appminhaideiadb.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import devandroid.aeca.appminhaideiadb.core.AppUtil;
import devandroid.aeca.appminhaideiadb.datamodel.ClienteDataModel;
import devandroid.aeca.appminhaideiadb.datamodel.ProdutoDataModel;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String  DB_NAME =  "AppMinhaIdeia.sqlite";
    public static final int DB_VERSION =  1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(AppUtil.TAG, "AppDataBase: Criando Banco de Dados");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.criarTabela());
        Log.d(AppUtil.TAG, "onCreate: Tabela Cliente criada " + ClienteDataModel.criarTabela());

        db.execSQL(ProdutoDataModel.criarTabela());
        Log.d(AppUtil.TAG, "onCreate: Tabela Produto criada " + ProdutoDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String tabela, ContentValues dados) {
        db = getWritableDatabase();
        boolean retorno = false;

        try {
            retorno = db.insert(tabela, null, dados) > 0;
        }
        catch(Exception err) {
            Log.d(AppUtil.TAG, "insert: " + err.getMessage());
        }
        return retorno;
    }

    public boolean update(String tabela, ContentValues dados) {
        db = getWritableDatabase();
        boolean retorno = false;

        try {
            retorno = db.update(tabela, dados,
                    "id=?", new String[] {String.valueOf(dados.get("id"))}) > 0;
        }
        catch(Exception err) {
            Log.d(AppUtil.TAG, "insert: " + err.getMessage());
        }
        return retorno;
    }

    public boolean deleteById(String tabela, int id) {
        db = getWritableDatabase();
        boolean retorno = false;

        try {
            retorno = db.delete(tabela, "id = ?", new String[] {String.valueOf(id)}) > 0;
        }
        catch(Exception err) {
            Log.d(AppUtil.TAG, "delete: " + err.getMessage());
        }
        return retorno;
    }
}
