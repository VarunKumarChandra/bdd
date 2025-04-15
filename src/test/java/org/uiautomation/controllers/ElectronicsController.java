package org.uiautomation.controllers;

import org.openqa.selenium.WebDriver;
import org.uiautomation.pages.ElectronicsPage;

public class ElectronicsController {

    private final WebDriver driver;
    private ElectronicsPage electronicsPage;

    public ElectronicsController(WebDriver driver) {
        this.driver = driver;
    }

    public ElectronicsPage getElectronicsPage() {
        return (electronicsPage == null) ? electronicsPage = new ElectronicsPage(driver) : electronicsPage;
    }
}
