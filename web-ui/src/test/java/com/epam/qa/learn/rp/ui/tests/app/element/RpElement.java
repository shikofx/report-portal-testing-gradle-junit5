package com.epam.qa.learn.rp.ui.tests.app.element;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import com.epam.qa.learn.rp.ui.tests.app.browser.BrowserManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class RpElement implements ChangableTimeout {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpElement.class);

    protected int implicitlyWait;

    protected RpElement(int implicitlyWait) {
        this.implicitlyWait = implicitlyWait;
        PageFactory.initElements(BrowserManager.browser().getDriver(), this);
    }

    protected boolean isElementDisplayed(By cssSelector) {
        return BrowserManager.browser().getDriver().findElement(cssSelector).isDisplayed();
    }

    protected boolean isElementPresent(By cssSelector) {
        return BrowserManager.browser().getDriver().findElements(cssSelector).size() > 0;
    }

    protected boolean isElementPresent(WebElement inElement, By cssSelector) {
        return inElement.findElements(cssSelector).size() > 0;
    }

    protected boolean isElementPresent(WebElement element, int secondsToWait) {
        setImplicitlyWait(secondsToWait);
        boolean isPresent = false;
        try {
            element.getTagName();
            isPresent = true;
        } catch (NullPointerException | NoSuchElementException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        setImplicitlyWait(implicitlyWait);
        return isPresent;
    }

    protected boolean isElementPresentAndVisible(WebElement element) {
        return BrowserManager.browser().driverWait().until(d -> element.isEnabled() && element.isDisplayed());
    }

    private Alert alertAfterClick(By cssLocator) {
        BrowserManager.browser().driverWait().until(visibilityOfElementLocated(cssLocator));
        return BrowserManager.browser().driverWait().until(d -> {
            d.findElement(cssLocator).click();
            try {
                return d.switchTo().alert();
            } catch (NoAlertPresentException e) {
                LOGGER.error(e.getLocalizedMessage());
                return null;
            }
        });
    }

    protected Alert alertAfterClick(WebElement element) {
        BrowserManager.browser().driverWait().until(visibilityOfAllElements(element));
        return BrowserManager.browser().driverWait().until(d -> {
            element.click();
            try {
                return d.switchTo().alert();
            } catch (NoAlertPresentException e) {
                LOGGER.error(e.getLocalizedMessage());
                return null;
            }
        });
    }

    public RpElement waitUntilAppear() {
        BrowserManager.browser().driverWait().until(d -> isElementPresentAndVisible(getElement()));
        return this;
    }

    public abstract WebElement getElement();
}
