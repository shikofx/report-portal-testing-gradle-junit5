package com.epam.qa.learn.rp.ui.tests.app.section;

public class SettingsForm extends RpSection {

    SettingsNavigator settingsNavigator;

    public SettingsForm(int iWait) {
        super(iWait);
    }

    public SettingsNavigator getNavigator() {
        return new SettingsNavigator(getImplicitlyWait());
    }

    public SettingsGeneralFormHelper getGeneralSettings() {
        return new SettingsGeneralFormHelper(getImplicitlyWait());
    }


}
