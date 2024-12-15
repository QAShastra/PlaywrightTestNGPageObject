
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
 //import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExceptionWithFailureScreenshot{

    // Report will generate in Project Directory only.
    // After execution, refresh project directory.
    ExtentSparkReporter htmlreport = new ExtentSparkReporter("target/Spark/HRMAppTestResults4.html");
    ExtentReports reports = new ExtentReports();


   // ExtentHtmlReporter htmlreport = new ExtentHtmlReporter(".\\Report\\Extent Report with Failure Screenshot.html");


    // This is the object of extentTest class, by which log is generate.
    ExtentTest testlog;


    @BeforeTest
    public void logWithScreenshot() throws IOException {

        System.out.println("Start");

        reports.attachReporter(htmlreport);

        // Customize Report property
        htmlreport.config().setReportName("Test Report");
        reports.setSystemInfo("Host Name", "QAShastra Host");
        reports.setSystemInfo("Environment", "Automation Testing");
        reports.setSystemInfo("User Name", "QA Automation");
        htmlreport.config().setDocumentTitle("Playwright Automation Report");
        //htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);

        // Two default theme of report
        htmlreport.config().setTheme(Theme.STANDARD);
        // htmlreport.config().setTheme(Theme.DARK);

        testlog = reports.createTest("Test Log Method-1");
        testlog.info("This is Info log");
        testlog.pass("This is Pass log");
        testlog.fail("This is Fail log");
        //testlog.error("This is Error log");

        testlog = reports.createTest("Test Log Method-2");
        testlog.log(Status.INFO, "This is Info log");
        testlog.log(Status.PASS, "This is Pass log");
        testlog.log(Status.FAIL, "This is Fail log");
        //testlog.log(Status.FATAL, "This is Fatal log");

        testlog = reports.createTest("Test log with Extent Color");
        testlog.log(Status.INFO, MarkupHelper.createLabel("This is Info log", ExtentColor.ORANGE));
        testlog.log(Status.PASS, MarkupHelper.createLabel("This is pass log", ExtentColor.CYAN));

    }

    @Test(testName = "Verify User Navigate to Admin Page", description = "Dashboard  Feature",priority = 0)
    public void navigateToAdminPageTest() throws InterruptedException {

        testlog = reports.createTest("passTest");
        testlog.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));

    }
    @Test
    public void passTest() {
        testlog = reports.createTest("passTest");
        Assert.assertTrue(true);
        testlog.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
    }

    @Test
    public void failTest() {
        testlog = reports.createTest("failTest");
        Assert.assertTrue(false);
        testlog.log(Status.PASS, "Test Case (failTest) Status is passed");
        testlog.log(Status.PASS, MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.GREEN));
    }

    @Test
    public void skipTest() {
        testlog = reports.createTest("skipTest");
        throw new SkipException("Skipping - This is not ready for testing ");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            testlog.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            testlog.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        //    File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           // BufferedImage img = ImageIO.read(screen);
            File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
          //  ImageIO.write(img, "png", new File(filetest + "\\Screenshots\\" + "Test01.png"));
            testlog.info("Details of " + "Test screenshot", MediaEntityBuilder
                    .createScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\" + "Test01.png")
                    .build());
        } else if (result.getStatus() == ITestResult.SKIP) {
            // testlog.log(Status.SKIP, "Test Case Skipped is "+result.getName());
            testlog.log(Status.SKIP,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
    }

    @AfterTest
    public void quit() {
        // If flush method did not call, Report will not generate.
        reports.flush();

        System.out.println("End");
    }
}