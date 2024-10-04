package devandroid.aeca.appminhaideiadb.model;

import android.util.Log;

import devandroid.aeca.appminhaideiadb.controller.ICrud;
import devandroid.aeca.appminhaideiadb.core.AppUtil;

public class Cliente implements ICrud {

    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void incluir() {
        Log.i(AppUtil.TAG, "incluir: Cliente");
    }

    @Override
    public void alterar() {
        Log.i(AppUtil.TAG, "alterar: Cliente");
    }

    @Override
    public void listar() {
        Log.i(AppUtil.TAG, "listar: Cliente");
    }

    @Override
    public void deletar() {
        Log.i(AppUtil.TAG, "deletar: Cliente");
    }
}
