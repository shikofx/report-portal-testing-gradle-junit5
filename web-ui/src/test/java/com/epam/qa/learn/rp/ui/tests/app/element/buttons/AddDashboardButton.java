package com.epam.qa.learn.rp.ui.tests.app.element.buttons;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddDashboardButton extends RpButton {

    @FindBy(xpath = "//*[contains(@class, 'addDashboardButton__add-dashboard-btn')]")
    private WebElement button;

    public AddDashboardButton(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public WebElement getElement() {
        return button;
    }


}
