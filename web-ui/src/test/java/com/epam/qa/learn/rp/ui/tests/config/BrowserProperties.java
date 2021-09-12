package com.epam.qa.learn.rp.ui.tests.config;

import com.epam.qa.learn.rp.ui.tests.model.User;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class BrowserProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserProperties.class);

    private static final String DEBUG_PROPERTIES = "/properties/application-debug.properties";
    private static final String CURRENT_PROPERTIES = "/properties/application.properties";

    private final String mainPageUrl;
    private final String username;
    private final String password;
    private final String grid;
    private final String browser;

    public String getGrid() {
        return grid;
    }

    public String getBrowser() {
        return browser;
    }

    public BrowserProperties() {
        mainPageUrl = loadProperty("site.url");
        username = loadProperty("account.username");
        password = loadProperty("account.password");
        browser = loadProperty("browser");
        grid = loadProperty("grid");
    }


    private String loadProperty(String name) {
        Properties properties = new Properties();
        String fromResource = System
            .getProperty(BrowserProperties.CURRENT_PROPERTIES, BrowserProperties.DEBUG_PROPERTIES);

        try {
            properties.load(BrowserProperties.class.getResourceAsStream(fromResource));
        } catch (IOException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        return properties.getProperty(name);
    }

    private Capabilities loadCapabilities(String fileName) {
        Properties fromProperties = new Properties();
        try {
            fromProperties.load(BrowserProperties.class.getResourceAsStream(fileName));
        } catch (IOException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (String name : fromProperties.stringPropertyNames()) {
            String value = fromProperties.getProperty(name);
            if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
                capabilities.setCapability(name, Boolean.valueOf(value));
            } else if (value.startsWith("file:")) {
                try {
                    capabilities.setCapability(name, new File(".", value.substring(5))
                        .getCanonicalFile().getAbsolutePath());
                } catch (IOException e) {
                    LOGGER.error(e.getLocalizedMessage());
                }
            } else {
                capabilities.setCapability(name, value);
            }
        }
        return capabilities;
    }

    public String getMainPageUrl() {
        return mainPageUrl;
    }

    public User getDefaultUser() {
        return new User(username, password);
    }
}
