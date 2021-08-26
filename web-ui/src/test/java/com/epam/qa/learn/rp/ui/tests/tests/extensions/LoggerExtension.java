package com.epam.qa.learn.rp.ui.tests.tests.extensions;

import com.epam.qa.learn.rp.ui.tests.utils.RpLogger;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LoggerExtension
    implements Extension, TestWatcher, BeforeAllCallback, BeforeEachCallback, AfterAllCallback {

    private List<TestResultStatus> testResultsStatus = new ArrayList<>();

    private String testClassName = "";

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        testClassName = context.getDisplayName();
        final String message = "Test class `%s`".formatted(context.getDisplayName());
        RpLogger.sendLaunch(getClass(), "info", message);
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        String parentName = context.getParent().get().getDisplayName();
        String testName = "";
        if (parentName.equals(testClassName)) {
            testName = context.getDisplayName();
        } else {
            testName = context.getParent().get().getDisplayName() + " -> " + context.getDisplayName();
        }
        final String message = "Test `%s`".formatted(testName);
        RpLogger.sendLaunch(getClass(), "info", message);
    }

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        final String message = "Test Disabled for test %s: with reason:- %s"
            .formatted(context.getDisplayName(), reason.orElse("No reason"));
        RpLogger.sendLaunch(getClass(), "error", message);

        testResultsStatus.add(TestResultStatus.DISABLED);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        final String message = "Test Successful for test %s: ".formatted(context.getDisplayName());
        RpLogger.sendLaunch(getClass(), "info", message);
        testResultsStatus.add(TestResultStatus.SUCCESSFUL);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        final String message = "Test Aborted for test %s: with reason:- %s"
            .formatted(context.getDisplayName(), cause.getLocalizedMessage());
        RpLogger.sendLaunch(getClass(), "error", message);

        testResultsStatus.add(TestResultStatus.ABORTED);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        final String message = "Test Aborted for test %s: with reason:- %s"
            .formatted(context.getDisplayName(), cause.getLocalizedMessage());

        RpLogger.sendLaunch(getClass(), "error", message);

        testResultsStatus.add(TestResultStatus.FAILED);
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final String message = "Test result summary for %s %s"
            .formatted(context.getDisplayName(), summary.toString());

        RpLogger.sendLaunch(getClass(), "error", message);
    }


}
