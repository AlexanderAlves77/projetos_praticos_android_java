package devandroid.aeca.applistacurso.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.aeca.applistacurso.database.ListaVipDB;
import devandroid.aeca.applistacurso.model.Pessoa;
import devandroid.aeca.applistacurso.view.MainActivity;

public class PessoaController extends ListaVipDB {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        super(mainActivity);

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        ContentValues dados = new ContentValues();

        Log.i("MVC Controller", "Salvo: " + pessoa.toString());

        listaVip.putString("primeiroNome:", pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome:", pessoa.getSobreNome());
        listaVip.putString("cursoDesejado:", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato:", pessoa.getTelefoneContato());
        listaVip.apply();

        dados.put("primeiroNome", pessoa.getPrimeiroNome());
        dados.put("sobreNome", pessoa.getSobreNome());
        dados.put("cursoDesejado", pessoa.getCursoDesejado());
        dados.put("telefoneContato", pessoa.getTelefoneContato());

        salvarObjeto("Pessoa", dados);
    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobreNome(preferences.getString("sobreNome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", "NA"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", "NA"));

        return pessoa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }
}
