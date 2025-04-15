package org.uiautomation.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.uiautomation.utils.PropertiesUtil;

public class WebDriverController {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) createDriver(PropertiesUtil.getInstance().getProperty("browser"));
        return driver;
    }

    private void createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (PropertiesUtil.getInstance().getProperty("headless").equalsIgnoreCase("true")) {
                    chromeOptions.addArguments("--headless=new");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }

    public void kill() {
        driver.quit();
    }
}
