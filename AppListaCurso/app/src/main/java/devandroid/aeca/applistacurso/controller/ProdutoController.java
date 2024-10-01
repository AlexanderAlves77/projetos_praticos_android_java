package devandroid.aeca.applistacurso.controller;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import devandroid.aeca.applistacurso.model.Pessoa;
import devandroid.aeca.applistacurso.view.MainActivity;

public class ProdutoController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public ProdutoController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.i("MVC_Controller", "Salvo: " + pessoa.toString());

        listaVip.putString("primeiroNome:", pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome:", pessoa.getSobreNome());
        listaVip.putString("nomeProduto:", pessoa.getProdutoDesejado());
        listaVip.putString("telefoneContato:", pessoa.getTelefoneContato());
        listaVip.apply();
    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobreNome(preferences.getString("sobreNome", "NA"));
        pessoa.setProdutoDesejado(preferences.getString("nomeProduto", "NA"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", "NA"));
        return pessoa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }
}
