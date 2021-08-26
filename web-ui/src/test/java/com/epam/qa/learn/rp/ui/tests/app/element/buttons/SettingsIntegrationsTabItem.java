package com.epam.qa.learn.rp.ui.tests.app.element.buttons;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsIntegrationsTabItem extends RpTabItem {

    @FindBy(xpath = ".//*[contains(@class, 'navigationTabs__tabs-wrapper')]//*[contains(@href, 'integrations')]")
    private WebElement tabItem;

    public SettingsIntegrationsTabItem(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public WebElement getElement() {
        return tabItem;
    }
}
