package com.epam.qa.learn.rp.ui.tests;

import com.epam.qa.learn.rp.ui.tests.tests.annotations.RpUITests;
import com.epam.qa.learn.rp.ui.tests.tests.base.PersonalPageTestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@RpUITests
class GeneralSettingsTest extends PersonalPageTestBase {

    @BeforeEach
    void openGeneralSettings() {
        bot.personalPage().sideBar()
            .openSettings();
    }

    @Test
    @Issue("Task 2")
    @Description("REGULAR user should be able to change General settings")
    void isAbleToChangeTest() {
        bot.personalPage().settings().getGeneralSettings()
            .verifyIsActive();
    }
}
