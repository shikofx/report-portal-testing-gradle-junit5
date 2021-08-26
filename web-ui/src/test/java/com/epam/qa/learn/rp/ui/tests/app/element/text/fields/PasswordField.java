package com.epam.qa.learn.rp.ui.tests.app.element.text.fields;

import com.epam.qa.learn.rp.ui.tests.app.selector.TitlePageSelectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordField extends EditableTextField {

    @FindBy(xpath = TitlePageSelectors.PASSWORD_SELECTOR)
    private WebElement inputField;

    public PasswordField(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public WebElement getElement() {
        return inputField;
    }
}
