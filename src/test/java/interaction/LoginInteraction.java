package interaction;

import pages.LoginPage;

public class LoginInteraction extends LoginPage {

    public LoginInteraction OpenUrl() {
        String url = "https://login.dafiti.com.br/";
        page.navigate(url);
        return this;
    }

    public LoginInteraction FillUser(String user) throws Exception {
        waitForElementsLambda(email, 10);
        performAction("Email", email, user, 10);
        return this;
    }

    public LoginInteraction FillPassword(String password) throws Exception {
        performAction("Password", senha, password, 10);
        return this;
    }

    public LoginInteraction ClickAcessar() throws InterruptedException {
        performAction("Acessar", entrar, null, 10);
        return this;
    }
}