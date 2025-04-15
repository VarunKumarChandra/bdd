package org.uiautomation.controllers;

import org.openqa.selenium.WebDriver;
import org.uiautomation.pages.LandingPage;

public class OthersController {

    private final WebDriver driver;
    private LandingPage landingPage;

    public OthersController(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() {
        return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;
    }
}
