package br.com.mobile.screen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import utils.Util;

public class HomeLogadoScreen extends BaseScreen {
    @AndroidFindBy(id="mensagem2")
    @iOSXCUITFindBy(accessibility = "message")
    private RemoteWebElement logado;

    public boolean validarTela(String texto) {
        return Util.obterTexto(logado.getText().equals(texto));
    }
}
