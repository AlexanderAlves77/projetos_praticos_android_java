package devandroid.aeca.meusclientes.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.List;

import devandroid.aeca.meusclientes.api.AppUtil;
import devandroid.aeca.meusclientes.datamodel.ClienteDataModel;
import devandroid.aeca.meusclientes.datasource.AppDataBase;
import devandroid.aeca.meusclientes.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);

        Log.i(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.CEP, obj.getCep());
        dadoDoObjeto.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        dadoDoObjeto.put(ClienteDataModel.NUMERO, obj.getNumero());
        dadoDoObjeto.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadoDoObjeto.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadoDoObjeto.put(ClienteDataModel.ESTADO, obj.getEstado());
        dadoDoObjeto.put(ClienteDataModel.TERMOS_DE_USO, obj.isTermosDeUso());

        return insert(ClienteDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean alterar(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());

        return update(ClienteDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public List<Cliente> listar() {
        return getAllClientes(ClienteDataModel.TABELA);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(ClienteDataModel.TABELA, id);
    }
}
