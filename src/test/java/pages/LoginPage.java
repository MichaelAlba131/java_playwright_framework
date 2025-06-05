package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import utils.Utils;
import utils.driver.PlaywrightDriver;

public class LoginPage extends Utils {
    protected Page page;
    public Locator email;
    public Locator senha;
    public Locator entrar;

    public LoginPage() {
        this.page = PlaywrightDriver.getPage();
        this.email = page.locator("//input[@name='email']");
        this.senha = page.locator("//input[@name='password']");
        this.entrar = page.locator("//button/div[contains(text(),'Entrar')]//ancestor::button");
    }
}