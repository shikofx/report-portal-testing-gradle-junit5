package com.epam.qa.learn.rp.ui.tests.app.element.buttons;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddWidjetButton extends RpButton {

    @FindBy(xpath = ".//*[contains(text(), 'Add new widget')]")
    private WebElement button;

    protected AddWidjetButton(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public WebElement getElement() {
        return button;
    }
}
