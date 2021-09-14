package com.epam.qa.learn.rp.ui.tests.app.browser;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.EDGE;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.OPERA;

import com.epam.qa.learn.rp.ui.tests.config.BrowserProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class BrowserManager {

    public static final int IMPLICITLY_WAIT = 5; //seconds
    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserManager.class);

    private final BrowserProperties properties;
    private static final ThreadLocal<Optional<BrowserManager>> instance =
        ThreadLocal.withInitial(Optional::empty);
    private WebDriver driver;
    private final WebDriverWait driverWait;

    private BrowserManager() {
        properties = new BrowserProperties();
        driver = initDriver();
        driverWait = new WebDriverWait(driver, 30);
    }

    public static BrowserManager browser() {
        if (!instance.get().isPresent()) {
            instance.set(Optional.of(new BrowserManager()));
        }

        return instance.get().get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait driverWait() {
        return BrowserManager.browser().driverWait;
    }

    public BrowserProperties getProperties() {
        return properties;
    }

    public void destroy() {
        instance.set(Optional.empty());
    }

    private WebDriver initDriver() {
        String gridAvailable = System.getProperty("grid");

        if (gridAvailable != null && gridAvailable.equals("true")) {
            String host = "localhost";
            if (System.getProperty("HUB_HOST") != null) {
                host = System.getProperty("HUB_HOST");
            }
            String completeUrl = "http://" + host + ":4444/wd/hub";

            DesiredCapabilities dCapabilities = DesiredCapabilities.chrome();
            if (System.getProperty("browser") != null) {
                switch (System.getProperty("browser")) {
                    case FIREFOX:
                        dCapabilities = DesiredCapabilities.firefox();
                        break;
                    case EDGE:
                        dCapabilities = DesiredCapabilities.edge();
                        break;
                }
            }

            try {
                return new RemoteWebDriver(new URL(completeUrl), dCapabilities);
            } catch (MalformedURLException e) {
                LOGGER.error(e.getLocalizedMessage());
            }
        }
        String browser = System.getProperty("browser");

        if (browser == null) {
            browser = "chrome";
        }

        if (browser.equals(FIREFOX)) {
            return new FirefoxDriver();
        } else if (browser.equals(EDGE)) {
            return new EdgeDriver();
        } else if (browser.equals(OPERA)) {
            return new OperaDriver();
        } else if (browser.equals(CHROME)) {
            return new ChromeDriver();
        }
        throw new ExceptionInInitializerError("Could not find competitive driver");
    }

    public BrowserManager maximizeWindow() {
        getDriver().manage().window().maximize();
        return this;
    }

    public BrowserManager clearCookies() {
        getDriver().manage().deleteAllCookies();
        return this;
    }
}
