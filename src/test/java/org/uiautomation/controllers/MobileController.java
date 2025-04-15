package org.uiautomation.controllers;

import org.openqa.selenium.WebDriver;
import org.uiautomation.pages.MobilePage;

public class MobileController {

    private final WebDriver driver;
    private MobilePage mobilePage;

    public MobileController(WebDriver driver) {
        this.driver = driver;
    }

    public MobilePage getMobilePage() {
        return (mobilePage == null) ? mobilePage = new MobilePage(driver) : mobilePage;
    }
}
