package com.epam.qa.learn.rp.ui.tests.app.element.buttons;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginButton extends RpButton {

    @FindBy(css = "button")
    private WebElement buttonElement;

    public LoginButton(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public WebElement getElement() {
        return buttonElement;
    }
}
