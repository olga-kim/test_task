package com.mckinsey.pages.epam;

import com.mckinsey.pages.BasePage;
import com.mckinsey.util.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    private static final String MENU_ITEM_LOCATOR_TEMPLATE = ".submenu-wrapper a[href$='%s']";

    @FindBy(css = ".tile-menu [href='/solutions']")
    private WebElement solutionsMenu;

    public MainPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.get(PropertiesUtil.getEpamUrl());
        return this;
    }

    private void openSolutionsMenu() {
        Actions builder = new Actions(driver);
        builder.moveToElement(solutionsMenu).build().perform();
    }

    public SolutionPage openSolutionPage(String menuItem) {
        openSolutionsMenu();

        By menuItemBy = By.cssSelector(String.format(MENU_ITEM_LOCATOR_TEMPLATE, menuItem));
        WebElement menuItemElement = waitUntilElementToBeClickable(menuItemBy);

        Actions builder = new Actions(driver);
        builder.click(menuItemElement).build().perform();

        return new SolutionPage(driver);
    }
}
