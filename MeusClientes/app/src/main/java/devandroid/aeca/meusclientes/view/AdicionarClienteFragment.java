package devandroid.aeca.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import devandroid.aeca.meusclientes.R;
import devandroid.aeca.meusclientes.api.AppUtil;
import devandroid.aeca.meusclientes.controller.ClienteController;
import devandroid.aeca.meusclientes.model.Cliente;


public class AdicionarClienteFragment extends Fragment {

    View view;
    TextView txtTitulo;
    EditText editNome, editTelefone, editEmail, editCep, editLogradouro;
    EditText editNumero, editBairro, editCidade, editEstado;
    CheckBox chkTermos;
    Button btnCancelar, btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;

    public AdicionarClienteFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_azul, container, false);

        iniciarComponenteLayout();

        escutarEventosDosBotoes();

        return view;
    }

    /**
     * Inicializar os componentes da tela para adicionar os clientes
     */
    private void iniciarComponenteLayout() {
        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.novoCliente);

        editNome = view.findViewById(R.id.editNome);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        chkTermos = view.findViewById(R.id.chkTermos);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getContext());
    }

    private void escutarEventosDosBotoes() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDataOk = true;

                if (TextUtils.isEmpty(editNome.getText())) {
                    isDataOk = false;
                    editNome.setError("Digite o nome completo...");
                    editNome.requestFocus();
                }

                if (TextUtils.isEmpty(editTelefone.getText())) {
                    isDataOk = false;
                    editTelefone.setError("Digite o telefone...");
                    editTelefone.requestFocus();
                }

                if (TextUtils.isEmpty(editEmail.getText())) {
                    isDataOk = false;
                    editEmail.setError("Digite o email...");
                    editEmail.requestFocus();
                }

                if (TextUtils.isEmpty(editCep.getText())) {
                    isDataOk = false;
                    editCep.setError("Digite o cep...");
                    editCep.requestFocus();
                }

                if (TextUtils.isEmpty(editLogradouro.getText())) {
                    isDataOk = false;
                    editLogradouro.setError("Digite o logradouro (avenida, estrada, rua)...");
                    editLogradouro.requestFocus();
                }

                if (TextUtils.isEmpty(editNumero.getText())) {
                    isDataOk = false;
                    editNumero.setError("Digite o número...");
                    editNumero.requestFocus();
                }

                if (TextUtils.isEmpty(editBairro.getText())) {
                    isDataOk = false;
                    editBairro.setError("Digite o bairro...");
                    editBairro.requestFocus();
                }

                if (TextUtils.isEmpty(editCidade.getText())) {
                    isDataOk = false;
                    editCidade.setError("Digite a cidade...");
                    editCidade.requestFocus();
                }

                if (TextUtils.isEmpty(editEstado.getText())) {
                    isDataOk = false;
                    editEstado.setError("Digite o estado (UF)...");
                    editEstado.requestFocus();
                }

                if (isDataOk) {
                    novoCliente.setNome(editNome.getText().toString());
                    novoCliente.setTelefone(editTelefone.getText().toString());
                    novoCliente.setEmail(editEmail.getText().toString());
                    novoCliente.setCep(Integer.parseInt(editCep.getText().toString()));
                    novoCliente.setLogradouro(editLogradouro.getText().toString());
                    novoCliente.setNumero(editNumero.getText().toString());
                    novoCliente.setBairro(editBairro.getText().toString());
                    novoCliente.setCidade(editCidade.getText().toString());
                    novoCliente.setEstado(editEstado.getText().toString());
                    novoCliente.setTermosDeUso(chkTermos.isChecked());

                    clienteController.incluir(novoCliente);
                }
                else {
                    Log.i("log_add_cliente", "onClick: Dados incorreto...");
                }
            }
        });
    }

}
