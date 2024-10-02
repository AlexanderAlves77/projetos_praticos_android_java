package devandroid.aeca.appgaseta.controller;

import android.content.SharedPreferences;

import devandroid.aeca.appgaseta.model.Combustivel;
import devandroid.aeca.appgaseta.view.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;
    SharedPreferences.Editor dadosPreference;

    // psfs
    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity activity) {
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreference = preferences.edit();
    }

    public void salvar(Combustivel combustivel) {
        dadosPreference.putString("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dadosPreference.putFloat("precoDoCombustive", (float)combustivel.getPrecoDoCombustivel());
        dadosPreference.putString("recomendacao", combustivel.getRecomendacao());
        dadosPreference.apply();
    }

    public void limpar() {
        dadosPreference.clear();
        dadosPreference.apply();
    }
}
