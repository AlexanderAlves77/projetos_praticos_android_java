package devandroid.aeca.appminhaideiadb.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.aeca.appminhaideiadb.R;
import devandroid.aeca.appminhaideiadb.model.Cliente;

public class SplashActivity extends AppCompatActivity {

    Cliente cliente;
    String TAG = "APP_MINHA_IDEIA";
    int waitingTime = 1000 * 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d(TAG, "onCreate: Tela Splash Carregada...");

        changeScreen();
    }

    private void changeScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cliente = new Cliente("Alexander Alves",
                        "teste@teste.com",
                        "22999998888",
                        47,
                        true);

                Intent changeOfScreen = new Intent(SplashActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nome", cliente.getNome());
                bundle.putString("email", cliente.getEmail());

                changeOfScreen.putExtras(bundle);

                startActivity(changeOfScreen);
                finish();
            }
        }, waitingTime);
    }

}