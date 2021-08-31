package com.epam.qa.learn.rp.ui.tests.app.section;

import com.epam.qa.learn.rp.ui.tests.app.element.SideBarElement;
import com.epam.qa.learn.rp.ui.tests.app.element.buttons.SideBarDashButton;
import com.epam.qa.learn.rp.ui.tests.app.element.buttons.SideBarSettingsButton;
import com.epam.qa.learn.rp.ui.tests.app.element.buttons.SideBarUserAvatarBlock;
import io.qameta.allure.Step;

public class PersonalSidebar extends RpSection {

    private SideBarElement userAvatar;
    private SideBarElement settingsButton;
    private SideBarElement dashboardButton;

    public PersonalSidebar(int implicitlyWait) {
        super(implicitlyWait);
        userAvatar = new SideBarUserAvatarBlock(implicitlyWait);
        settingsButton = new SideBarSettingsButton(implicitlyWait);
        dashboardButton = new SideBarDashButton(implicitlyWait);
    }

    public SideBarElement userAvatar() {
        return userAvatar;
    }

    public SideBarElement dashboardButton() {
        return dashboardButton;
    }

    public SideBarElement settingsButton() {
        return settingsButton;
    }

    @Step("Open settings for the user")
    public SettingsForm openSettings() {
        settingsButton.click();
        SettingsForm settingsForm = new SettingsForm(getImplicitlyWait());
        settingsForm.getNavigator().generalTab().waitUntilAppear();
        return settingsForm;
    }
}
