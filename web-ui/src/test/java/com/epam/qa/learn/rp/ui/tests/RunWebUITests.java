package com.epam.qa.learn.rp.ui.tests;

import com.epam.qa.learn.rp.ui.tests.utils.RpLogger;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

public class RunWebUITests {

    public static void main(String[] args) {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener summaryGeneratingListener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
            .request()
            .selectors(DiscoverySelectors.selectModule("web-ui"))
            .selectors(DiscoverySelectors.selectPackage("com.epam.qa.learn.rp.ui.tests"))
            .build();
        launcher.execute(request, summaryGeneratingListener);

        RpLogger.sendLaunch(RunWebUITests.class, "info", summaryGeneratingListener.getSummary().toString());
    }
}
