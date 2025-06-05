package utils.driver;

import com.microsoft.playwright.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PlaywrightDriver {

    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    public static void initialize() {
        String browserType = "chrome";
        boolean browserHeadless = false;

        playwright.set(Playwright.create());
        Browser browserInstance;
        switch (browserType.toUpperCase()) {
            case "CHROME":
                browserInstance = playwright.get().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(browserHeadless));
                break;
            case "FIREFOX":
                browserInstance = playwright.get().firefox().launch(new BrowserType.LaunchOptions().setHeadless(browserHeadless));
                break;
            case "WEBKIT":
                browserInstance = playwright.get().webkit().launch(new BrowserType.LaunchOptions().setHeadless(browserHeadless));
                break;
            case "CHROMIUM":
                browserInstance = playwright.get().chromium().launch(new BrowserType.LaunchOptions().setHeadless(browserHeadless));
                break;
            default:
                browserInstance = playwright.get().chromium().launch(new BrowserType.LaunchOptions().setHeadless(browserHeadless));
                break;
        }
        browser.set(browserInstance);
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions().setIgnoreHTTPSErrors(true);
        BrowserContext context = browserInstance.newContext(contextOptions);
        page.set(context.newPage());
    }


    public static Page getPage() {
        return page.get();
    }

    public static void close() {
        if (page.get() != null) page.get().close();
        if (browser.get() != null) browser.get().close();
        if (playwright.get() != null) playwright.get().close();
        page.remove();
        browser.remove();
        playwright.remove();
    }
}