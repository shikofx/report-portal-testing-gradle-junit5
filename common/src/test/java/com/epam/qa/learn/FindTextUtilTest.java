package com.epam.qa.learn;

import static com.epam.qa.learn.FindTextUtil.findAndReplace;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
class FindTextUtilTest {

    private final static String TEST_TEXT_ACTUAL = "Testin ReportPortal framework: mentoring program";
    private final static String TEST_TEXT_EXPECTED = "Testing ReportPortal framework: mentoring program";

    @Test
    void findAndReplaceTest() {
        Assertions.assertThat(findAndReplace(TEST_TEXT_ACTUAL, "Testin", "Testing")).isEqualTo(TEST_TEXT_EXPECTED);
    }

    @Test
    void findAndReplaceNegativeTest() {
        Assertions.assertThat(findAndReplace(TEST_TEXT_ACTUAL, "Alica", "")).isEqualTo(TEST_TEXT_ACTUAL);
    }
}