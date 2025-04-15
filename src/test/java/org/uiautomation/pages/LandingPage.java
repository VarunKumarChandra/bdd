package org.uiautomation.pages;

import org.openqa.selenium.WebDriver;

public class LandingPage extends Base {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLandingPage() {
        driver.get("https://www.amazon.in/");
    }
}
