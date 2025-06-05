package steps;

import interaction.LoginInteraction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class LoginSteps {

    private final LoginInteraction loginInteraction = new LoginInteraction();

    @Given("I open the url")
    @Step("Open the url") //Step Allure
    public void i_open_the_url() {
        loginInteraction.OpenUrl();
    }

    @When("I fill the {string} and {string}")
    @Step("Fill the User: {user} and Password: {password}")
    public void iFillTheAnd(String user, String password) throws Exception {
        loginInteraction
                .FillUser(user)
                .FillPassword(password)
                .ClickAcessar();
    }
}