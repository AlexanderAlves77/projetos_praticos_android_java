package devandroid.aeca.appminhaideiadb.controller;

import android.util.Log;

import devandroid.aeca.appminhaideiadb.core.AppUtil;

public class ClienteController {

    String versaoApp;

    public ClienteController() {
        this.versaoApp = AppUtil.versaoDoAplicativo();

        Log.i(AppUtil.TAG, "ClienteController: Versão App: " + versaoApp);
    }
}
