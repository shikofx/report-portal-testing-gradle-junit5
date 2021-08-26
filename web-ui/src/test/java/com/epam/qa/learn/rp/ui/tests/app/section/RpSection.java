package com.epam.qa.learn.rp.ui.tests.app.section;

public abstract class RpSection {

    private int implicitlyWait;

    public RpSection(int iWait) {
        implicitlyWait = iWait;
    }

    protected int getImplicitlyWait(){
        return implicitlyWait;
    }
}
