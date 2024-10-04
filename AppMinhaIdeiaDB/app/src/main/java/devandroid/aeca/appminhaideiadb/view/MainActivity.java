package devandroid.aeca.appminhaideiadb.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.aeca.appminhaideiadb.R;
import devandroid.aeca.appminhaideiadb.core.AppUtil;
import devandroid.aeca.appminhaideiadb.model.Cliente;

public class MainActivity extends AppCompatActivity {

    TextView txtNome;

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

        Log.d(AppUtil.TAG, "onCreate: Tela Principal Carregada...");

        Bundle bundle = getIntent().getExtras();

        Log.d(AppUtil.TAG, "onCreate: Nome..." + bundle.getString("nome"));
        Log.d(AppUtil.TAG, "onCreate: Email..." + bundle.getString("email"));

        txtNome = findViewById(R.id.txtNome);
        txtNome.setText("Bem vindo..." + bundle.getString("nome"));
    }
}