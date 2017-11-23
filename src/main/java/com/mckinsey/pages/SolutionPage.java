package com.mckinsey.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SolutionPage extends BasePage{

    @FindBy(className = "header-menu-crumbs")
    private WebElement breadCrumbs;

    SolutionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getBreadCrumbsText() {
        return breadCrumbs.getText();
    }
}
