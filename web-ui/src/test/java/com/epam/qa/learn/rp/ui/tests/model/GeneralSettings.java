package com.epam.qa.learn.rp.ui.tests.model;

public class GeneralSettings {
    private final String name;
    private String launchInactivityTimeout;
    private String keepLaunchesPeriod;
    private String keepLogsPeriod;
    private String keepAttachmentsPeriod;

    public GeneralSettings(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLaunchInactivityTimeout() {
        return launchInactivityTimeout;
    }

    public void setLaunchInactivityTimeout(String launchInactivityTimeout) {
        this.launchInactivityTimeout = launchInactivityTimeout;
    }

    public String getKeepLaunchesPeriod() {
        return keepLaunchesPeriod;
    }

    public void setKeepLaunchesPeriod(String keepLaunchesPeriod) {
        this.keepLaunchesPeriod = keepLaunchesPeriod;
    }

    public String getKeepLogsPeriod() {
        return keepLogsPeriod;
    }

    public void setKeepLogsPeriod(String keepLogsPeriod) {
        this.keepLogsPeriod = keepLogsPeriod;
    }

    public String getKeepAttachmentsPeriod() {
        return keepAttachmentsPeriod;
    }

    public void setKeepAttachmentsPeriod(String keepAttachmentsPeriod) {
        this.keepAttachmentsPeriod = keepAttachmentsPeriod;
    }


}
