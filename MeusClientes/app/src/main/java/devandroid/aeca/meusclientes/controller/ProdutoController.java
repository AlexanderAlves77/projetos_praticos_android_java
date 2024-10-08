package devandroid.aeca.meusclientes.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import devandroid.aeca.meusclientes.datamodel.ClienteDataModel;
import devandroid.aeca.meusclientes.datamodel.ProdutoDataModel;
import devandroid.aeca.meusclientes.datasource.AppDataBase;
import devandroid.aeca.meusclientes.model.Produto;

public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues dadoDoObjeto;

    public ProdutoController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Produto obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());

        return insert(ProdutoDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean alterar(Produto obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.ID, obj.getId());
        dadoDoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());

        return update(ProdutoDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();

        return lista;
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(ProdutoDataModel.TABELA, id);
    }
}
