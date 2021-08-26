package com.epam.qa.learn.rp.ui.tests.app.element.text.fields;

import static com.epam.qa.learn.rp.ui.tests.app.browser.BrowserManager.browser;

import com.epam.qa.learn.rp.ui.tests.app.element.RpElement;
import org.assertj.core.api.Assertions;

public abstract class TextField extends RpElement implements EditableField {

    protected TextField(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public void setText(String text) {
        browser().driverWait().until(d -> isElementPresentAndVisible(getElement()));
        getElement().click();
        getElement().clear();
        getElement().sendKeys(text);
        verifyIsTextEquals(text);
    }

    public void verifyIsTextEquals(String text) {
        Assertions.assertThat(getElement().getAttribute("defaultValue")).isEqualTo(text);
    }

    public void verifyPlaceholderEquals(String placeholder){
        Assertions.assertThat(getElement().getAttribute("placeholder")).isEqualTo(placeholder);
    }

    public void isDisplayed() {
        verifyIsTextEquals("default_personal");
    }
}
