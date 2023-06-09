package org.example.action;

import org.example.utility.WebDriverUtility;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageActions {

    WebDriver driver;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement homePageDashboard;

    public HomePageActions(){
        this.driver = WebDriverUtility.webDriver;
        PageFactory.initElements(driver, this);
    }

    public void verifyHomePageDisplayed(){
        Assert.assertTrue(homePageDashboard.isDisplayed());
    }
}
