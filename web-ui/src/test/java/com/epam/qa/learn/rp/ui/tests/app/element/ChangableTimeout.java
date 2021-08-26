package com.epam.qa.learn.rp.ui.tests.app.element;

import static java.util.concurrent.TimeUnit.SECONDS;

import com.epam.qa.learn.rp.ui.tests.app.browser.BrowserManager;

public interface ChangableTimeout {

    /**
     * @param timeout - seconds
     */
    default void setImplicitlyWait(int timeout) {
        BrowserManager.browser().getDriver().manage().timeouts().implicitlyWait(timeout, SECONDS);
    }

    /**
     * @param timeout - seconds
     */
    default void setPageLoadTimeout(int timeout) {
        BrowserManager.browser().getDriver().manage().timeouts().pageLoadTimeout(timeout, SECONDS);
    }

    /**
     * @param timeout - seconds
     */
    default void setScriptTimeout(int timeout) {
        BrowserManager.browser().getDriver().manage().timeouts().setScriptTimeout(timeout, SECONDS);
    }
}
