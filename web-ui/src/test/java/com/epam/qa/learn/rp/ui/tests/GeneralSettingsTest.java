package com.epam.qa.learn.rp.ui.tests;

import com.epam.qa.learn.rp.ui.tests.tests.annotations.RpUITests;
import com.epam.qa.learn.rp.ui.tests.tests.base.PersonalPageTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@RpUITests
class GeneralSettingsTest extends PersonalPageTestBase {

    @BeforeEach
    void openGeneralSettings() {
        bot.personalPage().sideBar()
            .openSettings();
    }

    @Test
    void isAbleToChangeTest() {
        bot.personalPage().settings().getGeneralSettings()
            .verifyIsActive();
    }
}
