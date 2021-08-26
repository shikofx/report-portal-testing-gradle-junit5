package com.epam.qa.learn.rp.ui.tests.tests.annotations;

import com.epam.qa.learn.rp.ui.tests.tests.extensions.LoggerExtension;
import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ExtendWith({ReportPortalExtension.class, LoggerExtension.class })
@Tag("ui")
public @interface RpUITests {

}
