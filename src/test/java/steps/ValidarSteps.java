package steps;

import interaction.ValidarInteraction;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

public class ValidarSteps {

    private final ValidarInteraction validarInteraction = new ValidarInteraction();

    @Then("I validate the error message {string}")
    @Step("Validate the error message {string}")
    public void iValidateTheErrorMessage(String mensagem) {
        validarInteraction.validarMensagemNaPagina(mensagem);
    }
}