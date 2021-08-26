package com.epam.qa.learn.rp.ui.tests.app.page;

import com.epam.qa.learn.rp.ui.tests.app.element.buttons.LoginButton;
import com.epam.qa.learn.rp.ui.tests.app.element.buttons.RpButton;
import com.epam.qa.learn.rp.ui.tests.app.element.text.fields.EditableTextField;
import com.epam.qa.learn.rp.ui.tests.app.element.text.fields.PasswordField;
import com.epam.qa.learn.rp.ui.tests.app.element.text.fields.UsernameField;
import com.epam.qa.learn.rp.ui.tests.app.section.RpSection;
import com.epam.qa.learn.rp.ui.tests.model.User;

public class TitlePageHelper extends RpSection {

    private EditableTextField usernameInput;
    private EditableTextField passwordInput;
    private RpButton submitButton;

    public TitlePageHelper(int iWait) {
        super(iWait);
        usernameInput = new UsernameField(getImplicitlyWait());
        passwordInput = new PasswordField(getImplicitlyWait());
        submitButton = new LoginButton(getImplicitlyWait());
    }

    public boolean login(User user) {
        usernameInput.setText(user.getUsername());
        passwordInput.setText(user.getPassword());
        submitButton.click();
        PersonalPageHelper personalPage = new PersonalPageHelper(getImplicitlyWait());
        personalPage.sideBar()
            .userAvatar()
            .waitUntilAppear();
        return true;
    }
}
