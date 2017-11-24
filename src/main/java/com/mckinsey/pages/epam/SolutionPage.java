package com.mckinsey.pages.epam;

import com.mckinsey.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SolutionPage extends BasePage {

    @FindBy(className = "header-menu-crumbs")
    private WebElement breadCrumbs;

    SolutionPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    public String getBreadCrumbsText() {
        return breadCrumbs.getText();
    }
}
