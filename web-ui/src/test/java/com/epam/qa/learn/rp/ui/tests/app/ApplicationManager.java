package com.epam.qa.learn.rp.ui.tests.app;

import com.epam.qa.learn.rp.ui.tests.app.page.TitlePageHelper;
import com.epam.qa.learn.rp.ui.tests.app.element.ChangableTimeout;
import com.epam.qa.learn.rp.ui.tests.app.page.PersonalPageHelper;
import com.epam.qa.learn.rp.ui.tests.app.browser.BrowserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationManager implements ChangableTimeout {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager() {
        setImplicitlyWait(BrowserManager.IMPLICITLY_WAIT);
    }

    public void goToTitlePage() {
        String titlePageUrl = BrowserManager.browser().getProperties().getMainPageUrl();
        LOGGER.info(String.format("->> Go to the Report Portal page: %s.", titlePageUrl));
        BrowserManager.browser().getDriver().get(titlePageUrl);
    }

    public void stop() {
        LOGGER.info("->> STOP browser and remove driver");
        BrowserManager.browser().getDriver().quit();
        BrowserManager.browser().destroy();
    }

    public TitlePageHelper titlePage() {
        return new TitlePageHelper(BrowserManager.IMPLICITLY_WAIT);
    }

    public PersonalPageHelper personalPage() {
        return new PersonalPageHelper(BrowserManager.IMPLICITLY_WAIT);
    }

}
