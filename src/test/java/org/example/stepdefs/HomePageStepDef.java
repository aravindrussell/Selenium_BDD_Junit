package org.example.stepdefs;

import io.cucumber.java.en.Then;
import org.example.action.HomePageActions;

public class HomePageStepDef {

    HomePageActions homePageActions = new HomePageActions();

    @Then("The user verify Home page displayed")
    public void theUserVerifyHomePageDisplayed() {
        homePageActions.verifyHomePageDisplayed();
    }
}
