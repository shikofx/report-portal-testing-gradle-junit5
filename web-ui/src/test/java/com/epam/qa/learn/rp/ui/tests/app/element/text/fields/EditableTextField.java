package com.epam.qa.learn.rp.ui.tests.app.element.text.fields;

import com.epam.qa.learn.rp.ui.tests.app.browser.BrowserManager;

public abstract class EditableTextField extends TextField implements EditableField {

    protected EditableTextField(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public void setText(String text) {
        BrowserManager.browser().driverWait().until(d -> isElementPresentAndVisible(getElement()));
        getElement().click();
        getElement().clear();
        getElement().sendKeys(text);
        verifyIsTextEquals(text);
    }
}
