package devandroid.aeca.meusclientes.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import devandroid.aeca.meusclientes.api.AppUtil;
import devandroid.aeca.meusclientes.datamodel.ClienteDataModel;
import devandroid.aeca.meusclientes.model.Cliente;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String  DB_NAME =  "MeusClientes.sqlite";
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

    public List<Cliente> getAllClientes(String tabela) {
        db = getWritableDatabase();
        List<Cliente> clientes = new ArrayList<>();
        Cliente obj;
        String sql = "SELECT * FROM " + tabela;

        Cursor cursor;
        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                obj = new Cliente();
                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));

                clientes.add(obj);
            }
            while (cursor.moveToNext());
        }
        return clientes;
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
