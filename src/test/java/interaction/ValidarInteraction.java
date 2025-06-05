package interaction;

import com.microsoft.playwright.Locator;
import pages.LoginPage;

public class ValidarInteraction extends LoginPage {

    public void validarMensagemNaPagina(String mensagem) {
        String xpath = "//*[contains(text(),'" + mensagem + "')]";
        boolean encontrada = false;
        for (int i = 0; i < 15; i++) {
            Locator locator = page.locator(xpath);
            if (locator.count() > 0) {
                encontrada = true;
                break;
            }
            try {
                Thread.sleep(1000); // espera 1 segundo antes de tentar novamente
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrompida", e);
            }
        }
        if (!encontrada) {
            throw new AssertionError("Mensagem não encontrada na página: " + mensagem);
        }
    }
}