package devandroid.aeca.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import devandroid.aeca.meusclientes.R;
import devandroid.aeca.meusclientes.controller.ClienteController;
import devandroid.aeca.meusclientes.model.Cliente;


public class ListarClientesFragment extends Fragment {

    View view;
    EditText editPesquisar;
    ListView listView;

    List<Cliente> clientesList;
    List<String> clientes;

    Cliente objCliente;
    ClienteController clienteController;

    ArrayAdapter<String> clienteAdapter;
    ArrayList<HashMap<String, String>> filtroClientes;

    public ListarClientesFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_listar_cliente, container, false);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.listar_clientes_fragment);

        txtTitulo.setTextColor(ColorStateList.valueOf(Color.RED));

        clienteController = new ClienteController(getContext());
        clientesList = clienteController.listar();
        // clientes = new ArrayList<>();

        listView = (ListView) view.findViewById(R.id.listView);
        editPesquisar = view.findViewById(R.id.editPesquisar);

        // TODO - Implementar regra de negócio na controladora classe cliente

        for (Cliente obj : clientesList) {
            clientes.add(obj.getId()+", "+obj.getNome());
        }

        clienteAdapter = new ArrayAdapter<>(getContext(),
                R.layout.listar_cliente_item, R.id.txtItemLista, clientes);

        listView.setAdapter(clienteAdapter);

        editPesquisar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence filtro, int start, int count, int after) {
                ListarClientesFragment.this.clienteAdapter.getFilter().filter(filtro);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }


}
