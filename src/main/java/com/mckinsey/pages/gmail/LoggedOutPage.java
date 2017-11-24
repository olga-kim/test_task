package com.mckinsey.pages.gmail;

import com.mckinsey.pages.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedOutPage extends BasePage {

    @FindBy(id = "signIn")
    private WebElement signInButton;

    public LoggedOutPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isUserLoggedOff(){
        try {
            waitUntilElementToBeClickable(signInButton);
            return true;
        }catch(TimeoutException e){
            return false;
        }
    }
}
