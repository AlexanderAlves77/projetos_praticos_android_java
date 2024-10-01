package br.com.fulldevstack.appsoma
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var primeiroNumero = 0
    var segundoNumero = 0
    var soma = 0
    var somatoria = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editPrimeiroNumero = findViewById<EditText>(R.id.editPrimeiroNumero)
        val editSegundoNumero = findViewById<EditText>(R.id.editSegundoNumero)
        val txtSomaCalculada = findViewById<TextView>(R.id.txtSomaCalculada)
        val txtSomatoriaCalculada = findViewById<TextView>(R.id.txtSomatoriaCalculada)
        val btnSomar = findViewById<Button>(R.id.btnSomar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)
    //    val btnSair = findViewById<Button>(R.id.btnSair)

        btnSomar.setOnClickListener {

            if (editPrimeiroNumero.text.toString().isEmpty()) {
                editPrimeiroNumero.setError("Campo Obrigatório...")
                editPrimeiroNumero.requestFocus()

            } else {

                primeiroNumero = editPrimeiroNumero.text.toString().toInt()
                segundoNumero = editSegundoNumero.text.toString().toInt()
                soma = primeiroNumero + segundoNumero
                somatoria += soma

                txtSomaCalculada.setText(soma.toString())
                txtSomatoriaCalculada.setText(somatoria.toString())
            }
            
            Toast.makeText(this, "Botão SOMAR clicado...",
                Toast.LENGTH_LONG).show()
        }

        btnLimpar.setOnClickListener {
            soma = 0
            txtSomaCalculada.setText("")
            editPrimeiroNumero.setText("")
            editSegundoNumero.setText("")

            Toast.makeText(this, "Botão LIMPAR clicado...",
                Toast.LENGTH_LONG).show()
        }
    }

    fun eventoSair(view: View) {
        Toast.makeText(this, "Botão SAIR clicado...",
            Toast.LENGTH_LONG).show()
        finish()
    }
}