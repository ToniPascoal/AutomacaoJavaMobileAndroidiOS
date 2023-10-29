package br.com.mobile.steps;

import br.com.mobile.screen.HomeLogadoScreen;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class HomeLogadoSteps {
    HomeLogadoScreen homeLogadoScreen = new HomeLogadoScreen();

    @Then("^valido a home do aplicativo$")
    public void valido_a_home_do_aplicativo() {
        assertTrue("", homeLogadoScreen.validarTela("Erro ao processar uma request =("));
    }
}
