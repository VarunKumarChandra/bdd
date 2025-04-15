package org.uiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MobilePage extends Base {

    @FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_mobiles']")
    protected WebElement headerMobile;

    @FindBy(xpath = "//h2[contains(text(),'Mobiles & Accessories')]")
    protected WebElement mobilePageHeading;


    public MobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToMobilePage() {
        headerMobile.click();
        Assert.assertTrue(mobilePageHeading.isDisplayed());
    }
}
