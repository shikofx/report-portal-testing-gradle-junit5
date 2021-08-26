package com.epam.qa.learn.rp.ui.tests.tests.base;

import com.epam.qa.learn.rp.ui.tests.app.browser.BrowserManager;
import org.junit.jupiter.api.BeforeEach;

public class PersonalPageTestBase extends TestBase {

    @BeforeEach
    void login() {
        bot.titlePage().login(BrowserManager.browser().getProperties().getDefaultUser());
    }
}
