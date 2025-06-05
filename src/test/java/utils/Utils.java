package utils;

import com.microsoft.playwright.Locator;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Assertions;
import utils.driver.PlaywrightDriver;

/**
 * Utils class for actions with Playwright elements.
 */
public class Utils {

    /**
     * Realiza uma ação em um elemento Playwright com tentativas múltiplas.
     *
     * @param field     Nome do campo para logs.
     * @param locator   Localizador do elemento a ser manipulado.
     * @param valor     Valor a ser preenchido ou utilizado na ação.
     * @param maxTries Quantidade máxima de tentativas antes de falhar.
     * @throws InterruptedException caso ocorra uma interrupção durante as tentativas.
     */
    public void performAction(String field, Locator locator, String valor, int maxTries) throws InterruptedException {
        int tries = 0;
        while (true) {
            try {
                performActionMethod(field, locator, valor);
                return;
            } catch (Exception e) {
                if (++tries >= maxTries) {
                    Assertions.fail("Erro ao realizar a ação. Tentativa " + tries + " de " + maxTries);
                }
                logMessage("Erro ao realizar a ação. Tentativa " + tries + " de " + maxTries);
                Thread.sleep(1000);
            }
        }
    }

    /**
     * Executa a ação correta no elemento de acordo com sua tag HTML.
     *
     * <ul>
     *   <li>Caso seja um <code>&lt;input&gt;</code> do tipo texto, preenche o valor.</li>
     *   <li>Caso seja um <code>&lt;input&gt;</code> do tipo submit/button, clica.</li>
     *   <li>Caso seja um <code>&lt;input&gt;</code> do tipo checkbox, marca se necessário.</li>
     *   <li>Caso seja um <code>&lt;button&gt;</code>, clica.</li>
     *   <li>Caso seja um <code>&lt;select&gt;</code>, seleciona a opção.</li>
     * </ul>
     *
     * @param field     Nome do campo para logs.
     * @param locator   Localizador do elemento.
     * @param valor     Valor a ser preenchido ou selecionado.
     */
    public void performActionMethod(String field, Locator locator, String valor) {
        try {
            String tagName = locator.evaluate("el => el.tagName").toString();
            switch (tagName.toUpperCase()) {
                case "INPUT":
                    String type = locator.getAttribute("type");
                    if ("submit".equalsIgnoreCase(type) || "button".equalsIgnoreCase(type)) {
                        locator.click();
                        logMessage(field + " clicked ");
                    } else if ("checkbox".equalsIgnoreCase(type)) {
                        if (!locator.isChecked()) {
                            locator.check();
                            logMessage(field + " checked ");
                        }
                    } else {
                        locator.fill(valor);
                    }
                    break;
                case "BUTTON":
                    locator.click();
                    break;
                case "SELECT":
                    locator.selectOption(valor);
                    break;
                default:
                    throw new Exception("Unsupported HTML tag: " + tagName);
            }
        } catch (Exception e) {
            logMessage(field + " no actionable steps were performed ");
            throw new RuntimeException(e);
        }
    }

    /**
     * Exibe uma mensagem de log no console.
     *
     * @param message Mensagem a ser exibida.
     */
    public void logMessage(String message) {
        System.out.println(message);
    }

    /**
     * Aguarda o aparecimento de um elemento pelo tempo especificado.
     *
     * @param locator            Localizador do elemento.
     * @param timeToWaitSeconds  Tempo máximo a aguardar (em segundos).
     */
    public static void waitForElementsLambda(Locator locator, int timeToWaitSeconds) {
        if (locator != null) {
            locator.waitFor(new Locator.WaitForOptions().setTimeout(timeToWaitSeconds * 1000L));
        }
    }

    /**
     * Captura e anexa um screenshot da página ao relatório Allure.
     *
     * @return Array de bytes representando a imagem capturada.
     */
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] attachScreenshot() {
        return PlaywrightDriver.getPage().screenshot();
    }
}