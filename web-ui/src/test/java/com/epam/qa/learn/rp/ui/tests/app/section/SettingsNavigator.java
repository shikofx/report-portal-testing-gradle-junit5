package com.epam.qa.learn.rp.ui.tests.app.section;

import com.epam.qa.learn.rp.ui.tests.app.element.buttons.SettingsGeneralTabItem;
import com.epam.qa.learn.rp.ui.tests.app.element.buttons.SettingsIntegrationsTabItem;

public class SettingsNavigator extends RpSection {

    public SettingsNavigator(int iWait) {
        super(iWait);
    }

    public SettingsGeneralTabItem generalTab() {
        return new SettingsGeneralTabItem(getImplicitlyWait());
    }

    public SettingsIntegrationsTabItem integrationsTab() {
        return new SettingsIntegrationsTabItem(getImplicitlyWait());
    }
}
