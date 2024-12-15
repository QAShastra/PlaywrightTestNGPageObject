import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Page;
import org.hrm.DashboardPage;
import org.hrm.LoginPage;
import org.playwrightfactory.PlaywrightFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class DashboardTest {

    PlaywrightFactory pf ;
    Page page =null;
    DashboardPage dashboardPage =null;
    LoginPage loginpage = null;

    ExtentReports extent =null;
    ExtentSparkReporter spark = null;
     @BeforeClass
    public void intialReportObject(){
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark/HRMAppTestResults2.html");
         extent.attachReporter(spark);

    }
    @BeforeTest
    public void setup(){

        System.out.println("Base Test Class - setup Method");
        pf =  new PlaywrightFactory();
        page =pf.launchPlaywrightBrowser("chromium");
        loginpage = new LoginPage(page);
        dashboardPage = new DashboardPage(page);
        loginpage.loginHRM("Admin","admin123");
    }

    @Test(testName = "Verify User Navigate to Admin Page", description = "Dashboard  Feature",priority = 0)
    public void navigateToAdminPageTest() throws InterruptedException {

        String expectedValue = "User Management";
        String actualValue = dashboardPage.navigateToAdmin();
        System.out.println("actual value is " +actualValue);
        Assert.assertEquals(actualValue, expectedValue);
        extent.createTest("Verify User Navigate to Admin Page")
                .log(Status.PASS, "Verify User Navigate to Admin Page, and it passed!");

    }
    @Test(testName = "Verify User Navigate to PIM Page", description = "Dashboard  Feature",priority = 1)
    public void navigateToPIMPageTest() throws InterruptedException {
        String expectedValue = "PIM";
        String actualValue = dashboardPage.navigateToPIM();
        System.out.println("actual value is " +actualValue);
        Assert.assertEquals(actualValue, expectedValue);
        extent.createTest("Verify User Navigate to Admin Page")
                .log(Status.PASS, "Verify User Navigate to Admin Page, and it passed!");
    }

    @AfterTest
    public void tearDown(){

        page.close();

    }

    @AfterClass
    public void tearDownReport(){
        extent.flush();
    }

}
