package com.mckinsey.data;

import org.testng.annotations.DataProvider;

public class BreadCrumbsData {
    @DataProvider(name = "getMenuItemData")
    public static Object[][] getMenuItemData() {
        return new Object[][]{
                {"core-engineering", "Home\nSolutions\nCore Engineering"},
                {"product-development", "Home\nSolutions\nCore Engineering\nProduct Development"},
                {"engineering-excellence", "Home\nSolutions\nCore Engineering\nEngX"},
                {"core-technologies", "Home\nSolutions\nCore Engineering\nCore Technologies"},
                {"assurance", "Home\nSolutions\nCore Engineering\nAssurance"}
        };
    }
}
