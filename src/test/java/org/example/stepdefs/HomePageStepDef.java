package org.example.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.action.HomePageActions;
import org.example.manager.PageObjectManager;
import org.junit.Assert;

import java.io.IOException;

public class HomePageStepDef {

    PageObjectManager pageObjectManager = new PageObjectManager();

    @Then("The user verify Home page displayed")
    public void theUserVerifyHomePageDisplayed() throws IOException {
        pageObjectManager.getExtendReporting().assertTrue(
                pageObjectManager.getHomePageActions().getHomePageDisplayed(),
                "Home Page is Displayed");
    }

    @Then("The user verify Incorrect User")
    public void theUserVerifyIncorrectUser() {
        pageObjectManager.getExtendReporting().assertTrue(
                pageObjectManager.getLoginAction().getInvalidCredLabelDisplayed(),
                "Invalid Label displayed");
    }

}
