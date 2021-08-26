package com.epam.qa.learn.rp.ui.tests.app.element.buttons;

import com.epam.qa.learn.rp.ui.tests.app.element.SideBarElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarDashButton extends SideBarElement {

    @FindBy(xpath = ".//*[contains(@class, 'sidebar__sidebar-btn')]//*[contains(@href, 'dashboard')]")
    WebElement buttonElement;

    public SideBarDashButton(int implicitlyWait) {
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
