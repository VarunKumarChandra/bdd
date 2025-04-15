package org.uiautomation.stepDefs;

import io.cucumber.java.en.Given;
import org.uiautomation.context.Context;
import org.uiautomation.pages.LandingPage;

public class LandingPageSteps {

    final LandingPage landingPage;

    public LandingPageSteps(Context context) {
        landingPage = context.getOthersController().getLandingPage();
    }

    @Given("User is on landing page for amazon")
    public void user_is_on_landing_page_for_amazon() {
        landingPage.navigateToLandingPage();
    }
}
