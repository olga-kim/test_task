package com.mckinsey.pages.gmail;

import com.mckinsey.pages.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailboxPage extends BasePage {

    private final static Logger LOGGER = Logger.getLogger(MailboxPage.class);

    private static final String EXPECTED_TITLE = "Inbox - kim.tam.java@gmail.com - Gmail";

    @FindBy(xpath = "//*[contains(text(), 'COMPOSE')]")
    private WebElement composeButton;

    @FindBy(xpath = "//*[contains(text(), 'Drafts')][contains(@class, 'J-Ke')]")
    private WebElement draftsLink;

    @FindBy(xpath = "//*[contains(text(), 'Sent Mail')][contains(@class, 'J-Ke')]")
    private WebElement sentMailLink;

    @FindBy(css = "span.gb_9a")
    private WebElement accountInfo;

    @FindBy(id = "gb_71")
    private WebElement logOffButton;

    @FindBy(name = "to")
    private WebElement toInput;

    @FindBy(name = "subjectbox")
    private WebElement subjectInput;

    @FindBy(xpath = "//*[contains(@class, 'Ar Au')]//*[contains(@aria-label, 'Message Body')]")
    private WebElement bodyInput;

    @FindBy(xpath = "//*[contains(@aria-label, 'Save & Close')]")
    private WebElement closeButton;

    @FindBy(css = ".aDm>span")
    private WebElement recipientField;

    @FindBy(xpath = "//*[contains(@class, 'J-J5-Ji')][contains(text(), 'Send')]")
    private WebElement sendButton;

    public MailboxPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void composeLetter() {
        waitUntilElementToBeClickable(composeButton).click();
    }

    public void clickDraftsLink() {
        waitUntilElementToBeClickable(draftsLink).click();
    }

    public void clickSentMailLink() {
        waitUntilElementToBeClickable(sentMailLink).click();
    }

    public void clickAccountInfo() {
        waitUntilElementToBeClickable(accountInfo).click();
    }

    public void logOff() {
        waitUntilElementToBeClickable(logOffButton).click();
    }

    public boolean isLoginSuccessful() {
        try {
            waitUntilTitleIs(EXPECTED_TITLE);
            return true;
        } catch (TimeoutException e) {
            LOGGER.info("Actual title: " + driver.getTitle());
            return false;
        }
    }

    public void fillRecipients(String recipient) {
        waitUntilElementToBeClickable(toInput).sendKeys(recipient);
    }

    public void fillSubject(String subject) {
        waitUntilElementToBeClickable(subjectInput).sendKeys(subject);
    }

    public void fillBody(String body) {
        waitUntilElementToBeClickable(bodyInput).sendKeys(body);
    }

    public void closeLetterComposer() {
        waitUntilElementToBeClickable(closeButton).click();
    }

    public void openLetter(String subject) {
        waitUntilElementToBeClickable(getLetterLocatorBySubject(subject)).click();
    }

    public boolean isLetterWithSubjectPresent(String subject) {
        try {
            waitUntilElementToBeClickable(getLetterLocatorBySubject(subject));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitUntilLetterDisappear(String subject) {
        waitUntilElementDisappear(getLetterLocatorBySubject(subject));
    }

    private By getLetterLocatorBySubject(String subject) {
        return By.xpath(String.format("//*[contains(@class, 'y6')]//*[contains(text(), '%s')]", subject));
    }

    public String getRecipientAddress() {
        return waitUntilElementToBeClickable(recipientField).getAttribute("email");
    }

    public void clickSend() {
        waitUntilElementToBeClickable(sendButton).click();
    }

    public boolean isDraftFolderOpen() {
        try {
            waitUntilUrlContains("drafts");
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isSentFolderOpen() {
        try {
            waitUntilUrlContains("sent");
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
