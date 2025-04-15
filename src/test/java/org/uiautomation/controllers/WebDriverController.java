package org.uiautomation.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.uiautomation.utils.PropertiesUtil;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverController {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) createDriver(PropertiesUtil.getInstance().getProperty("browser"));
        return driver;
    }

    private void createDriver(String browser) {
        String gridUrl = PropertiesUtil.getInstance().getProperty("selenium.grid.url");
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (PropertiesUtil.getInstance().getProperty("headless").equalsIgnoreCase("true")) {
                        chromeOptions.addArguments("--headless=new");
                    }
                    driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    driver = new RemoteWebDriver(new URL(gridUrl), edgeOptions);
                    break;
                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Selenium Grid URL: " + gridUrl, e);
        }
    }

    public void kill() {
        if (driver != null) {
            driver.quit();
        }
    }
}