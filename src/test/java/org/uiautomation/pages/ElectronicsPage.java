package org.uiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ElectronicsPage extends Base {


    @FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_electronics']")
    protected WebElement headerElectronics;

    @FindBy(xpath = "//span[text()='Starting ₹299 | Headphones, Smartwatches & more']")
    protected WebElement electronicsPageHeading;


    public ElectronicsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToElectronicsPage() {
        headerElectronics.click();
        Assert.assertTrue(electronicsPageHeading.isDisplayed());
    }

}
