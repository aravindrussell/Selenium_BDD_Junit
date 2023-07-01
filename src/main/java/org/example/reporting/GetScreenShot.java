package org.example.reporting;

import org.example.manager.PageObjectManager;
import org.example.utility.WebDriverUtility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class GetScreenShot {

    private static PageObjectManager pageObjectManager = new PageObjectManager();

    public static String takeScreenShot() throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) WebDriverUtility.webDriver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/screenshots/"
                +  pageObjectManager.getDateTimeUtility().getCurrentDateTime()
                + ".png";
        File finalDestination = new File(destination);
        FileHandler.copy(source, finalDestination);
        return destination;
    }

}
