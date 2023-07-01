package org.example.action;

import org.example.utility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAction {

    WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordElement;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//p[text()='Invalid credentials']")
    WebElement invalidCredLabel;

    public LoginAction() {
        this.driver = WebDriverUtility.webDriver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username){
        userName.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordElement.sendKeys(password);
    }

    public void getApplication(String url){
        driver.get(url);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public boolean getInvalidCredLabelDisplayed() { return invalidCredLabel.isDisplayed(); }
}
