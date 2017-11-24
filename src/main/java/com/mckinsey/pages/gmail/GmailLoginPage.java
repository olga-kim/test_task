package com.mckinsey.pages.gmail;

import com.mckinsey.pages.BasePage;
import com.mckinsey.util.PropertiesUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage extends BasePage {

    private static final String LOGIN = "kim.tam.java";
    private static final String PASSWORD = "tam.java";

    @FindBy(id = "identifierId")
    private WebElement loginInput;

    @FindBy(id = "identifierNext")
    private WebElement nextButton;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "passwordNext")
    private WebElement signInButton;

    @FindBy(css = "div>.WaidBe")
    private WebElement gmailIcon;

    public GmailLoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(PropertiesUtil.getGmailUrl());
    }

    public void fillLogin() {
        waitUntilElementToBeClickable(loginInput).sendKeys(LOGIN);
    }

    public void clickNext() {
        waitUntilElementToBeClickable(nextButton).click();
    }

    public void fillPassword() {
        waitUntilElementToBeClickable(passwordInput).sendKeys(PASSWORD);
    }

    public void clickSignIn() {
        waitUntilElementToBeClickable(signInButton).click();
    }

    public void clickGmailIcon() {
        waitUntilElementToBeClickable(gmailIcon).click();
    }
}
