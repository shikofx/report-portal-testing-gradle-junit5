package com.epam.qa.learn.rp.ui.tests.app.browser;

import static com.epam.qa.learn.rp.ui.tests.config.BrowserType.CHROME;
import static com.epam.qa.learn.rp.ui.tests.config.BrowserType.EDGE;
import static com.epam.qa.learn.rp.ui.tests.config.BrowserType.FIREFOX;
import static com.epam.qa.learn.rp.ui.tests.config.BrowserType.HTMLUNIT;
import static com.epam.qa.learn.rp.ui.tests.config.BrowserType.IE;
import static com.epam.qa.learn.rp.ui.tests.config.BrowserType.OPERA;
import static com.epam.qa.learn.rp.ui.tests.config.BrowserType.PHANTOMJS;
import static com.epam.qa.learn.rp.ui.tests.config.BrowserType.SAFARI;

import com.epam.qa.learn.rp.ui.tests.config.BrowserProperties;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class BrowserManager {

    public static final int IMPLICITLY_WAIT = 5; //seconds
    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserManager.class);
    public static final String ROOT_PROJECT_NAME = "report-portal-taf-java-junit5";
    public static final String CHROMEDRIVER_WIN = "chromedriver.exe";

    private final BrowserProperties properties;
    private static final ThreadLocal<Optional<BrowserManager>> instance =
        ThreadLocal.withInitial(Optional::empty);
    private final WebDriver driver;
    private final WebDriverWait driverWait;

    private BrowserManager() {
        properties = new BrowserProperties();
        LOGGER.info(
            "Open ner browser instance: type = '%s'".formatted(getProperties().getCapabilities().getBrowserName()));
        driver = createDriver();
        driverWait = new WebDriverWait(driver, 30);
    }

    public static BrowserManager browser() {
        if (instance.get().isEmpty()) {
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

    private WebDriver createDriver() {
        if (properties.getGridHubUrl().isPresent() && !properties.getGridHubUrl().get().equals("")) {
            DesiredCapabilities remoteCapabilities = new DesiredCapabilities();
            remoteCapabilities.setBrowserName(properties.getCapabilities().getBrowserName());
            remoteCapabilities.setPlatform(Platform.fromString(properties.getPlatform()));
            try {
                return new RemoteWebDriver(new URL(properties.getGridHubUrl().get()), remoteCapabilities);
            } catch (MalformedURLException e) {
                LOGGER.error(e.getLocalizedMessage());
            }
        } else {
            String browser = properties.getCapabilities().getBrowserName();
            Path path = Paths.get(System.getProperty("user.dir"));

            //TODO: Replace with Gradle API (Project.getRootProject().getName()
            if (!path.endsWith(ROOT_PROJECT_NAME)) {
                path = path.getParent();
            }

            switch (browser) {
                case CHROME:
                    String
                        driverPath = Paths.get(path.toString(),
                                               getProperties().getDriverFolder(),
                                               CHROMEDRIVER_WIN).toString();
                    LOGGER.info(driverPath);
                    System.setProperty("webdriver.chrome.driver", driverPath);
                    return new ChromeDriver();

                case FIREFOX:
                    return new FirefoxDriver();
                case IE:
                    return new InternetExplorerDriver();
                case SAFARI:
                    return new SafariDriver();
                case PHANTOMJS:
                    return new PhantomJSDriver();
                case HTMLUNIT:
                    return new HtmlUnitDriver();
                case EDGE:
                    return new EdgeDriver();
                case OPERA:
                    return new OperaDriver();
            }
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
