package org.uiautomation.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.uiautomation.context.Context;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Hooks {

    private final Context context;
    private WebDriver driver;


    public Hooks(Context context) {
        this.context = context;
    }

    @Before
    public void beforeHook() {
        driver = context.getWebDriverController().getDriver();
        driver.manage().window().maximize();
    }


    @After
    public void afterHook(Scenario scenario) {
        if (scenario.isFailed()) {
            File inputStream = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Allure.attachment(scenario.getName(), Files.newInputStream(inputStream.toPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        context.getWebDriverController().kill();
    }


}
