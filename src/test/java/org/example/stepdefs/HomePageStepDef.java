package org.example.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.action.HomePageActions;
import org.junit.Assert;

public class HomePageStepDef {

    HomePageActions homePageActions = new HomePageActions();

    @Then("The user verify Home page displayed")
    public void theUserVerifyHomePageDisplayed() {
        homePageActions.verifyHomePageDisplayed();
    }

    @Then("The user verify Incorrect User")
    public void theUserVerifyIncorrectUser() {
        Assert.assertFalse(homePageActions.getHomePageDisplayed());
    }

}
