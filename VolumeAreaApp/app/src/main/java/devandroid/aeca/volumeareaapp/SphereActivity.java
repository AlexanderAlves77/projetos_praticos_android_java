package devandroid.aeca.volumeareaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SphereActivity extends AppCompatActivity {

    EditText sphere_radius;
    TextView textView2, result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shape);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sphere_radius = findViewById(R.id.editText_sphere);
        textView2 = findViewById(R.id.textView2);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = sphere_radius.getText().toString();

                int r = Integer.parseInt(radius);

                // V = (4/3) * pi * r^3

                double volume = (4/3) * 3.14159 * (r*r*r);
                result.setText("V = "+volume+" m^3");
            }
        });
    }
}