package org.example.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.Assert;

import java.io.IOException;

public class ExtendReporting {

    public static ExtentReports extentReports;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentKlovReporter extentKlovReporter;
    public static ExtentTest extentTest;

    public void initExtentReporting(String reportName, String documentTitle){
        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(reportName);
        extentKlovReporter = new ExtentKlovReporter("Selenium BDD Jnuit")
                .initWithDefaultSettings();
        extentSparkReporter.config(
                ExtentSparkReporterConfig.builder()
                        .theme(Theme.DARK)
                        .documentTitle(documentTitle)
                        .build()
        );
//        extentSparkReporter.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.flush();
    }

    public void createNewScenario(String scenarioName){
        extentTest = extentReports.createTest(scenarioName).log(Status.INFO,"Stating the Scenario <b>" + scenarioName + "</b>");
        extentReports.flush();
    }

    public void loggingInfoInReport(String info){
        extentTest.log(Status.INFO,info);
        extentReports.flush();
    }

    public void assertTrue(boolean boolValue, String infoToDisplay) throws IOException {
        try{
            Assert.assertTrue(infoToDisplay,boolValue);
            extentTest.log(Status.PASS,infoToDisplay);
        }catch (AssertionError e){
            extentTest.log(Status.FAIL,infoToDisplay);
            extentTest.addScreenCaptureFromPath(GetScreenShot.takeScreenShot(), "Screen is below");
        }
    }
}
