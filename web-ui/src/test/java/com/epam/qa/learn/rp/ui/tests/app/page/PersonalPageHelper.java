package com.epam.qa.learn.rp.ui.tests.app.page;

import com.epam.qa.learn.rp.ui.tests.app.section.PersonalSidebar;
import com.epam.qa.learn.rp.ui.tests.app.section.RpSection;
import com.epam.qa.learn.rp.ui.tests.app.section.SettingsForm;

public class PersonalPageHelper extends RpSection {

    public PersonalPageHelper(int iWait) {
        super(iWait);
    }

    public PersonalSidebar sideBar() {
        return new PersonalSidebar(getImplicitlyWait());
    }

    public SettingsForm settings() {
        return new SettingsForm(getImplicitlyWait());
    }

    public void logout() {
        //TODO: not implemented method
    }
}
