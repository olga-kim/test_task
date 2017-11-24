package com.mckinsey.pages;

import com.mckinsey.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int EXPLICIT_WAIT_TIMEOUT = 10;

    protected WebDriver driver;
    private WebDriverWait wait;

    protected BasePage() {
        this.driver = Browser.getWebDriver();
        this.wait = new WebDriverWait(this.driver, EXPLICIT_WAIT_TIMEOUT);
    }

    protected WebElement waitUntilElementToBeClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilTitleIs(String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    protected void waitUntilUrlContains(String url) {
        wait.until(ExpectedConditions.urlContains(url));
    }

    protected void waitUntilElementDisappear(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}
