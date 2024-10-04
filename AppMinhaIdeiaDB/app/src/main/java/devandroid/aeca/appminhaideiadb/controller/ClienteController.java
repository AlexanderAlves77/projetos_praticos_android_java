package devandroid.aeca.appminhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import devandroid.aeca.appminhaideiadb.core.AppUtil;
import devandroid.aeca.appminhaideiadb.datamodel.ClienteDataModel;
import devandroid.aeca.appminhaideiadb.datasource.AppDataBase;
import devandroid.aeca.appminhaideiadb.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);

        Log.i(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        //dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        return true;
    }

    @Override
    public boolean alterar(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        return true;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();


        return lista;
    }

    @Override
    public boolean deletar(Cliente obj) {
        dadoDoObjeto = new ContentValues();
        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        return true;
    }
}
