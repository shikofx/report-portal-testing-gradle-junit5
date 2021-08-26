package com.epam.qa.learn.rp.ui.tests.app.section;

import com.epam.qa.learn.rp.ui.tests.app.element.text.fields.SettingsGeneralNameField;
import com.epam.qa.learn.rp.ui.tests.app.element.text.fields.TextField;

public class SettingsGeneralFormHelper extends SettingsForm {

    private TextField name;

    public SettingsGeneralFormHelper(int implicitlyWait) {
        super(implicitlyWait);
        name = new SettingsGeneralNameField(getImplicitlyWait());
    }

    public void verifyIsActive() {
        name.isDisplayed();
    }
}
