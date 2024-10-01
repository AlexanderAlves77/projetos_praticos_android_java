package devandroid.aeca.applistacurso.view;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import devandroid.aeca.applistacurso.R;
import devandroid.aeca.applistacurso.controller.ProdutoController;
import devandroid.aeca.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    ProdutoController controller;
    Pessoa pessoa;

    EditText editName;
    EditText editSecondName;
    EditText editProduct;
    EditText editTelefone;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

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

        controller = new ProdutoController(MainActivity.this);
        controller.toString();
        pessoa = new Pessoa();
        controller.buscar(pessoa);

        editName = findViewById(R.id.editName);
        editSecondName = findViewById(R.id.editSecondName);
        editProduct = findViewById(R.id.editProduct);
        editTelefone = findViewById(R.id.editTelefone);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editName.setText(pessoa.getPrimeiroNome());
        editSecondName.setText(pessoa.getSobreNome());
        editProduct.setText(pessoa.getProdutoDesejado());
        editTelefone.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editName.setText("");
                editSecondName.setText("");
                editProduct.setText("");
                editTelefone.setText("");

                controller.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editName.getText().toString());
                pessoa.setSobreNome(editSecondName.getText().toString());
                pessoa.setProdutoDesejado(editProduct.getText().toString());
                pessoa.setTelefoneContato(editTelefone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();
                controller.salvar(pessoa);
            }
        });

        Log.i("POOAndroid","Objeto pessoa: "+pessoa.toString());
    }
}