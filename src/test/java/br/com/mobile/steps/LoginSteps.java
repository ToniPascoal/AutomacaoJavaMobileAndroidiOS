package br.com.mobile.steps;

import br.com.mobile.screen.LoginScreen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    LoginScreen screenLogin = new LoginScreen();

    @Given("^que aplicativo esta aberto$")
    public void que_aplicativo_esta_aberto()  {
        assertTrue("", screenLogin.validarTela("Bem vindo Novamente"));
    }

    @When("^fizer login$")
    public void fizer_login() {
        screenLogin.logar("qazando@gmail.com", "1234");
    }
}