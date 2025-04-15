package org.uiautomation.context;

import org.uiautomation.controllers.ElectronicsController;
import org.uiautomation.controllers.MobileController;
import org.uiautomation.controllers.OthersController;
import org.uiautomation.controllers.WebDriverController;

public class Context {

    private final WebDriverController webDriverController;
    private OthersController othersController;
    private ElectronicsController electronicsController;
    private MobileController mobileController;

    public Context() {
        webDriverController = new WebDriverController();
        mobileController = new MobileController(webDriverController.getDriver());
        electronicsController = new ElectronicsController(webDriverController.getDriver());
        othersController = new OthersController(webDriverController.getDriver());
    }

    public WebDriverController getWebDriverController() {
        return webDriverController;
    }

    public MobileController getMobileController() {
        return (mobileController == null) ? mobileController = new MobileController(webDriverController.getDriver()) : mobileController;
    }

    public ElectronicsController getElectronicsController() {
        return (electronicsController == null) ? electronicsController = new ElectronicsController(webDriverController.getDriver()) : electronicsController;
    }

    public OthersController getOthersController() {
        return (othersController == null) ? othersController = new OthersController(webDriverController.getDriver()) : othersController;
    }
}
