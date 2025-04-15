package org.uiautomation.stepDefs;

import io.cucumber.java.en.Then;
import org.uiautomation.context.Context;
import org.uiautomation.pages.ElectronicsPage;


public class ElectronicsPageSteps {

    final ElectronicsPage electronicsPage;

    public ElectronicsPageSteps(Context context) {
        electronicsPage = context.getElectronicsController().getElectronicsPage();
    }

    @Then("User navigates to Electronics Page")
    public void navigateToElectronicsPage() {
        electronicsPage.navigateToElectronicsPage();
    }

}
