package com.epam.qa.learn.rp.ui.tests.app.element.buttons;

import com.epam.qa.learn.rp.ui.tests.app.element.SideBarElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarUserAvatarBlock extends SideBarElement {

    @FindBy(xpath = ".//*[contains(@class, 'userBlock__user-block')]")
    WebElement blockElement;

    public SideBarUserAvatarBlock(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public void click() {
        blockElement.click();
    }

    @Override
    public WebElement getElement(){
        return blockElement;
    }
}
