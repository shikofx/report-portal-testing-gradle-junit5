package com.epam.qa.learn.rp.ui.tests.app.element.buttons;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsGeneralTabItem extends RpTabItem {

    @FindBy(xpath = ".//*[contains(@class, 'navigationTabs__tabs-wrapper')]//*[contains(@href, 'general')]")
    private WebElement tabItem;

    public SettingsGeneralTabItem(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public WebElement getElement() {
        return tabItem;
    }
}
