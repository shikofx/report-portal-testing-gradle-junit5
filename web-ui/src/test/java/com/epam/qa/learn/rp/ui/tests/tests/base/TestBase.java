package com.epam.qa.learn.rp.ui.tests.tests.base;

import com.epam.qa.learn.rp.ui.tests.app.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    public static ApplicationManager bot = new ApplicationManager();

    @BeforeEach
    void setUp() {
        bot.goToTitlePage();
    }

    @AfterEach
    void closePage() {
        bot.stop();
    }
}
