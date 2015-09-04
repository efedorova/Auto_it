package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage() {
        driver.get(ApplicationManager.baseUrl + "/index.php");
    }

    public void gotoGroupsPage() {
        click(By.linkText("groups"));
    }
}
