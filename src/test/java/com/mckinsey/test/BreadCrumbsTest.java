package com.mckinsey.test;

import com.mckinsey.data.BreadCrumbsData;
import com.mckinsey.pages.MainPage;
import com.mckinsey.pages.SolutionPage;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class BreadCrumbsTest extends BaseTest {

    @Test(dataProvider = "getMenuItemData", dataProviderClass = BreadCrumbsData.class)
    public void breadCrumbsTest(String menuItem, String breadCrumbs) {

        MainPage mainPage = new MainPage().open();
        SolutionPage solutionPage = mainPage.openSolutionPage(menuItem);

        assertEquals(solutionPage.getBreadCrumbsText(), breadCrumbs);
    }
}
