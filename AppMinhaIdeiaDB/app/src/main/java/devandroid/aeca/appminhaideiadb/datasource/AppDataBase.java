package devandroid.aeca.appminhaideiadb.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import devandroid.aeca.appminhaideiadb.core.AppUtil;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String  DB_NAME =  "AppMinhaIdeia.sqlite";
    public static final int DB_VERSION =  1;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(AppUtil.TAG, "AppDataBase: Criando Banco de Dados");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
