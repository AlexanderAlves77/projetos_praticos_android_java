package devandroid.aeca.ferramentalayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textTitle;
    EditText editTextName;
    Button btnConfirm;

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

        textTitle = findViewById(R.id.textTitle);
        editTextName = findViewById(R.id.editTextName);
        btnConfirm = findViewById(R.id.btnConfirm);

        textTitle.setText("Retrato Principal");

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDataOk = true;

                if (TextUtils.isEmpty(editTextName.getText().toString())) {
                    editTextName.setError("Digite o nome completo, por favor!");
                    isDataOk = false;
                }
                else {
                    Toast.makeText(getBaseContext(), "Você digitou: " + editTextName.getText(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}