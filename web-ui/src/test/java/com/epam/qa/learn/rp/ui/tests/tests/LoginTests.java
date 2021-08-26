package com.epam.qa.learn.rp.ui.tests.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.qa.learn.rp.ui.tests.tests.annotations.RpUITests;
import com.epam.qa.learn.rp.ui.tests.tests.base.TestBase;
import com.epam.qa.learn.rp.ui.tests.tests.data.RpUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@RpUITests
class LoginTests extends TestBase {

    @ParameterizedTest
    @EnumSource
    @DisplayName("Login to Report Portal")
    void loginTest(RpUser user) {
        assertThat(bot.titlePage().login(user.getUser())).isTrue();
    }
}
