package com.epam.qa.learn.rp.ui.tests.app.element.buttons;

import com.epam.qa.learn.rp.ui.tests.app.element.SideBarElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarSettingsButton extends SideBarElement {

    @FindBy(xpath = ".//*[contains(@class, 'sidebar__sidebar-btn')]//*[contains(@href, 'settings')]")
    WebElement buttonElement;

    public SideBarSettingsButton(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public void click() {
        buttonElement.click();
    }

    @Override
    public WebElement getElement() {
        return buttonElement;
    }
}
