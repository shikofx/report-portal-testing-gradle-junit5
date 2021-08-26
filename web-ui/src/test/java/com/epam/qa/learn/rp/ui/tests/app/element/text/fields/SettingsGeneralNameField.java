package com.epam.qa.learn.rp.ui.tests.app.element.text.fields;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsGeneralNameField extends TextField {

    @FindBy(xpath = "//*[contains(text(), 'Name')]/following-sibling::div/input")
    private WebElement nameInput;

    public SettingsGeneralNameField(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public WebElement getElement() {
        return nameInput;
    }
}
