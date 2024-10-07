package devandroid.aeca.ferramentalayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textTitle;
    EditText editTextName;
    Button btnConfirm;
    SwitchCompat switchShow;
    ToggleButton toggleButton;

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
        toggleButton = findViewById(R.id.toggleButton);
        switchShow = findViewById(R.id.switchShow);

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

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switchShow.isChecked())
                    editTextName.setEnabled(false);
                else
                    editTextName.setEnabled(true);
            }
        });

        switchShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newTitle = textTitle.getText().toString().toUpperCase();

                if(switchShow.isChecked()) {
                    textTitle.setVisibility(View.GONE);
                }
                else {
                    textTitle.setVisibility(View.VISIBLE);
                    textTitle.setText(newTitle);
                }
            }
        });
    }
}