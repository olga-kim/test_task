package com.mckinsey.test;

import com.mckinsey.browser.Browser;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    @AfterSuite
    public void tearDown() {
        Browser.closeWebDriver();
    }
}
