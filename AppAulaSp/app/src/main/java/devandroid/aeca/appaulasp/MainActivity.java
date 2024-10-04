package devandroid.aeca.appaulasp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "App_Aula_SP";
    private static final String PREF_NOME = "App_Aula_SP_preg";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    int codigoProduto;
    String nomeProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.i(TAG, "onCreate: Rodando");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);
        Log.i(TAG, "onCreate: Pasta Shared Criada!");

        dados = sharedPreferences.edit();
        nomeProduto = "Notebook";
        codigoProduto = 12345;
        precoProduto = 997.97f;
        estoque = true;

        dados.putString("nomeProduto", nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("precoProduto", precoProduto);
        dados.putBoolean("estoque", estoque);
        dados.apply();

        // Modo de Debug
        Log.i(TAG, "onCreate: Dados para serem salvos");
        Log.w(TAG, "onCreate: Produto: " + nomeProduto);
        Log.w(TAG, "onCreate: Código: " + codigoProduto);
        Log.w(TAG, "onCreate: Preço: " + precoProduto);
        Log.w(TAG, "onCreate: Tem no Estoque: " + estoque);

        /*
        dados.clear();
        */
        dados.apply();

        /* Apagando um dado
        dados.remove("estoque")
        dados.apply();
        */

        Log.i(TAG, "onCreate: Dados Recuperados");
        Log.d(TAG, "onCreate: Produto: " + sharedPreferences.getString("nomeProduto", "fora de estoque"));
        Log.d(TAG, "onCreate: Código: " + sharedPreferences.getInt("nomeProduto", -1));
        Log.d(TAG, "onCreate: Preço: " + sharedPreferences.getFloat("nomeProduto", -1.0f));
        Log.d(TAG, "onCreate: Tem no Estoque: " + sharedPreferences.getBoolean("nomeProduto", false));

    }
}