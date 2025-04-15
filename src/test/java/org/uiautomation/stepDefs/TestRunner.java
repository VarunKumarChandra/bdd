package org.uiautomation.stepDefs;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/featureFiles"},
        glue = {""},
        monochrome = true,
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "pretty",
                "html:target/output.html",
//                "testng",
//                "progress",
//                "json:build/cucumber-reports/cucumber.json",
//                "rerun:build/cucumber-reports/rerun.txt"
        })
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
