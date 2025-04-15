package org.uiautomation.stepDefs;

import io.cucumber.java.en.Then;
import org.uiautomation.context.Context;
import org.uiautomation.pages.MobilePage;

public class MobilePageSteps {

    final MobilePage mobilePage;

    public MobilePageSteps(Context context) {
        mobilePage = context.getMobileController().getMobilePage();
    }

    @Then("User navigates to Mobiles Page")
    public void user_navigates_to_Mobile_Page() {
        mobilePage.navigateToMobilePage();
    }
}
