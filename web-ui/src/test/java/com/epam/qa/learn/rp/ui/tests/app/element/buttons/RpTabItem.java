package com.epam.qa.learn.rp.ui.tests.app.element.buttons;

import com.epam.qa.learn.rp.ui.tests.app.element.Clickable;
import com.epam.qa.learn.rp.ui.tests.app.element.RpElement;

public abstract class RpTabItem extends RpElement implements Clickable {

    protected RpTabItem(int implicitlyWait) {
        super(implicitlyWait);
    }

    @Override
    public void click(){
        getElement().click();
    }
}
