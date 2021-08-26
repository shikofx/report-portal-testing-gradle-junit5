package com.epam.qa.learn.rp.ui.tests.app.element.text.fields;

import static com.epam.qa.learn.rp.ui.tests.app.selector.TitlePageSelectors.USERNAME_SELECTOR;

import com.epam.qa.learn.rp.ui.tests.app.selector.TitlePageSelectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsernameField extends EditableTextField {

    @FindBy(xpath = USERNAME_SELECTOR)
    private WebElement inputField;

    public UsernameField(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public WebElement getElement() {
        return inputField;
    }
}
