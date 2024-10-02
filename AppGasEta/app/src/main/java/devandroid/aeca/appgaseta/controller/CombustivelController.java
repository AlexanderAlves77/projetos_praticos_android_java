package devandroid.aeca.appgaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import java.util.List;

import devandroid.aeca.appgaseta.database.GasEtaDB;
import devandroid.aeca.appgaseta.model.Combustivel;
import devandroid.aeca.appgaseta.view.GasEtaActivity;

public class CombustivelController extends GasEtaDB {

    SharedPreferences preferences;
    SharedPreferences.Editor dadosPreference;

    // psfs
    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity activity) {
        super(activity);

        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreference = preferences.edit();
    }

    public void salvar(Combustivel combustivel) {
        ContentValues dados = new ContentValues();

        dadosPreference.putString("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dadosPreference.putFloat("precoDoCombustive", (float)combustivel.getPrecoDoCombustivel());
        dadosPreference.putString("recomendacao", combustivel.getRecomendacao());
        dadosPreference.apply();

        dados.put("nomeDocombustivel", combustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        salvarObjeto("Combustivel", dados);
    }

    public List<Combustivel> getListaDeDados() {
        return listarDados();
    }

    public void alterar(Combustivel combustivel) {
        ContentValues dados = new ContentValues();

        dados.put("id", combustivel.getId());
        dados.put("nomeDocombustivel", combustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        alterarObjeto("Combustivel", dados);
    }

    public void limpar() {
        dadosPreference.clear();
        dadosPreference.apply();
    }
}
