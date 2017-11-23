package com.mckinsey.pages;

import com.mckinsey.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {

    private static final int WAIT_FOR_ELEMENT_TIMEOUT = 10;

    WebDriver driver;

    BasePage() {
        this.driver = Browser.getWebDriver();
    }

    WebElement waitUntilElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


}
