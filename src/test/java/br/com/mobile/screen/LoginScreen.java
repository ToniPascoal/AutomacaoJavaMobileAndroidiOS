package br.com.mobile.screen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import utils.Util;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(id="login_username")
    @iOSXCUITFindBy(accessibility = "username")
    private RemoteWebElement campoemail;

    @AndroidFindBy(id="login_password")
    @iOSXCUITFindBy(accessibility = "password")
    private RemoteWebElement camposenha;

    @AndroidFindBy(id="login_button")
    @iOSXCUITFindBy(accessibility = "login_btn")
    private RemoteWebElement botaologar;

    @AndroidFindBy(id="welcome_txt")
    @iOSXCUITFindBy(accessibility = "welcome")
    private RemoteWebElement welcome;

    public boolean validarTela(String texto) {
        return Util.obterTexto(welcome.getText().equals(texto));
    }

    public void logar(String email, String senha){
        campoemail.sendKeys(email);
        camposenha.sendKeys(senha);
        botaologar.click();
    }
}
