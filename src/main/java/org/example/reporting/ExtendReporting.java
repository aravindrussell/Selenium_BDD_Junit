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

    public void initExtentReporting(String reportName, String documentTitle) {
        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(reportName);
        extentKlovReporter = new ExtentKlovReporter("Selenium BDD Jnuit")
                .initWithDefaultSettings();
        Logging.info("Creating extent report file");
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

    public void createNewScenario(String scenarioName) {
        extentTest = extentReports.createTest(scenarioName).log(Status.INFO, "Stating the Scenario <b>" + scenarioName + "</b>");
        Logging.info("Stating the Scenario <b>" + scenarioName + "</b>");
        extentReports.flush();
    }

    public void loggingInfoInReport(String info) {
        extentTest.log(Status.INFO, info);
        Logging.info(info);
        extentReports.flush();
    }

    public void assertTrue(boolean boolValue, String infoToDisplay) {
        try {
            Assert.assertTrue(infoToDisplay, boolValue);
            Logging.pass(infoToDisplay);
            extentTest.log(Status.PASS, infoToDisplay);
            extentTest.addScreenCaptureFromPath(GetScreenShot.takeScreenShot(), "Screen is below");
        } catch (AssertionError e) {
            try {
                e.printStackTrace();
                Logging.error("Assession error on step : " + infoToDisplay);
                extentTest.log(Status.FAIL, infoToDisplay);
                extentTest.addScreenCaptureFromPath(GetScreenShot.takeScreenShot(), "Screen is below");
                Assert.fail(infoToDisplay);
            } catch (IOException ioException) {
                ioException.printStackTrace();
                Logging.error("Screenshot not attached to extent report");
            } catch (AssertionError assertionError) {
                assertionError.printStackTrace();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            Logging.error("Screenshot not attached to extent report");
        }
        extentReports.flush();
    }

    public void assertFalse(boolean boolValue, String infoToDisplay) {
        try {
            Assert.assertFalse(infoToDisplay, boolValue);
            Logging.info(infoToDisplay);
            extentTest.log(Status.PASS, infoToDisplay);
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail(infoToDisplay);
            Logging.error("Assession error on step : " + infoToDisplay);
            extentTest.log(Status.FAIL, infoToDisplay);
            try {
                extentTest.addScreenCaptureFromPath(GetScreenShot.takeScreenShot(), "Screen is below");
            } catch (IOException ex) {
                ex.printStackTrace();
                Logging.error("Screenshot not attached to extent report");
            }
        }
        extentReports.flush();
    }

    public void pass(boolean boolValue, String infoToDisplay) {
        try {
            Assert.assertTrue(infoToDisplay, true);
            extentTest.log(Status.PASS, infoToDisplay);
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail(infoToDisplay);
            Logging.error("Assession error on step : " + infoToDisplay);
            extentTest.log(Status.FAIL, infoToDisplay);
            try {
                extentTest.addScreenCaptureFromPath(GetScreenShot.takeScreenShot(), "Screen is below");
            } catch (IOException ex) {
                ex.printStackTrace();
                Logging.error("Screenshot not attached to extent report");
            }
        }
        extentReports.flush();
    }

    public void fail(boolean boolValue, String infoToDisplay) {
        Logging.error("Assession error on step : " + infoToDisplay);
        Assert.fail(infoToDisplay);
        extentTest.log(Status.FAIL, infoToDisplay);
        try {
            extentTest.addScreenCaptureFromPath(GetScreenShot.takeScreenShot(), "Screen is below");
        } catch (IOException e) {
            e.printStackTrace();
            Logging.error("Screenshot not attached to extent report");
        }
        extentReports.flush();
    }

    public void assertEquals(String expectedValue, String actualValue, String infoToDisplay) {
        try {
            Assert.assertEquals(expectedValue, actualValue, infoToDisplay);
            extentTest.log(Status.PASS, infoToDisplay);
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail(infoToDisplay);
            Logging.error("Assession error on step : " + infoToDisplay);
            extentTest.log(Status.FAIL, infoToDisplay);
            try {
                extentTest.addScreenCaptureFromPath(GetScreenShot.takeScreenShot(), "Screen is below");
            } catch (IOException ex) {
                ex.printStackTrace();
                Logging.error("Screenshot not attached to extent report");
            }
        }
        extentReports.flush();
    }
}
