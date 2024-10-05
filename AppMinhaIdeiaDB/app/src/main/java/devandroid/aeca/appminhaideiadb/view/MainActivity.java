package devandroid.aeca.appminhaideiadb.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.aeca.appminhaideiadb.R;
import devandroid.aeca.appminhaideiadb.controller.ClienteController;
import devandroid.aeca.appminhaideiadb.core.AppUtil;
import devandroid.aeca.appminhaideiadb.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente cliente;

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

        clienteController = new ClienteController(getApplicationContext());


        for (int i = 0; i < 49; i++) {
            cliente = new Cliente();
            cliente.setNome("Alexander Alves " + i);
            cliente.setEmail(i+"_aeca@teste.com.br");
            clienteController.incluir(cliente);
        }

        for (Cliente obj : clienteController.listar()) {
            Log.e("Cliente", "onCreate: " + obj.getId()+" "+ obj.getNome()+" "+ obj.getEmail());
        }
    }
}