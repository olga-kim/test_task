package com.mckinsey.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.mckinsey.pages.gmail.GmailLoginPage;
import com.mckinsey.pages.gmail.LoggedOutPage;
import com.mckinsey.pages.gmail.MailboxPage;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;

public class SeleniumTest extends BaseTest {

    private static final String RECIPIENT = "olga.l.kim@mail.ru";
    private static final String SUBJECT = "Test message " + RandomUtils.nextInt(0, 10000);
    private static final String BODY = "Hello";

    @Test
    public void loginTest() {

        GmailLoginPage loginPage = new GmailLoginPage();
        loginPage.openPage();
        loginPage.fillLogin();
        loginPage.clickNext();
        loginPage.fillPassword();
        loginPage.clickSignIn();
        loginPage.clickGmailIcon();

        MailboxPage mailboxPage = new MailboxPage();
        assertTrue(mailboxPage.isLoginSuccessful(), "Login is unsuccessful");
    }

    @Test(dependsOnMethods = "loginTest")
    public void draftLetter() {
        MailboxPage mailboxPage = new MailboxPage();
        mailboxPage.composeLetter();

        mailboxPage.fillRecipients(RECIPIENT);
        mailboxPage.fillSubject(SUBJECT);
        mailboxPage.fillBody(BODY);
        mailboxPage.closeLetterComposer();

        mailboxPage.clickDraftsLink();
        assertTrue(mailboxPage.isDraftFolderOpen(), "Drafts folder is not open");
        assertTrue(mailboxPage.isLetterWithSubjectPresent(SUBJECT),
                   String.format("There is no letter with '%s' SUBJECT in Drafts folder", SUBJECT));
    }

    @Test(dependsOnMethods = "draftLetter")
    public void findDraftLetterInFolder() {
        MailboxPage mailboxPage = new MailboxPage();
        mailboxPage.openLetter(SUBJECT);

        assertEquals(mailboxPage.getRecipientAddress(), RECIPIENT, "Unexpected recipient");
    }

    @Test(dependsOnMethods = "findDraftLetterInFolder")
    public void noLetterInDraftAfterSending() {
        MailboxPage mailboxPage = new MailboxPage();

        mailboxPage.clickSend();
        assertTrue(mailboxPage.isDraftFolderOpen(), "Drafts folder is not open");
        mailboxPage.waitUntilLetterDisappear(SUBJECT);
        assertFalse(mailboxPage.isLetterWithSubjectPresent(SUBJECT),
                    String.format("There is a letter with '%s' subject in Drafts folder", SUBJECT));
    }

    @Test(dependsOnMethods = "noLetterInDraftAfterSending")
    public void letterInSentMail() {
        MailboxPage mailboxPage = new MailboxPage();
        mailboxPage.clickSentMailLink();
        assertTrue(mailboxPage.isSentFolderOpen(), "Sent folder is not open");
        assertTrue(mailboxPage.isLetterWithSubjectPresent(SUBJECT),
                   String.format("There is no letter with '%s' subject in Sent Mail folder", SUBJECT));
    }

    @Test(dependsOnMethods = "letterInSentMail")
    public void checkLogOff() {
        MailboxPage mailboxPage = new MailboxPage();
        mailboxPage.clickAccountInfo();
        mailboxPage.logOff();

        LoggedOutPage loggedOutPage = new LoggedOutPage();
        assertTrue(loggedOutPage.isUserLoggedOff(), "User wasn't logged out");
    }

}
