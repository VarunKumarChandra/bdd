package org.uiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.uiautomation.utils.ExcelUtil;
import org.uiautomation.utils.PropertiesUtil;

public class Base {

    final WebDriver driver;
    final PropertiesUtil propertiesUtil;
    final ExcelUtil excelUtil;

    public Base(WebDriver driver) {
        this.driver = driver;
        propertiesUtil = PropertiesUtil.getInstance();
        excelUtil = new ExcelUtil(PropertiesUtil.getInstance().getProperty("excelPath"));
    }
}
