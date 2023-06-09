package org.example.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverUtility {

    String BrowserName = "";

    public static WebDriver webDriver;

    public WebDriver getWebDriver(String browserName) {

        WebDriver driver;
        switch (browserName){
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("Chrome Driver Was Launched");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("Edge Driver Was Launched");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("Firefox Driver Was Launched");
                break;
            default:
                System.out.println("Mension Browser name not available");
                throw new WebDriverException("Browser Name not Found");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().getPageLoadTimeout();
        return driver;
    }
}
