
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginwithExtendReportIntegration {

    ExtentReports extent =null;
    ExtentSparkReporter spark = null;
   @BeforeClass
   public void intialReportObject(){
       extent = new ExtentReports();
       spark = new ExtentSparkReporter("target/Spark/HRMAppTestResults1.html");
       extent.attachReporter(spark);

   }
   @Test(testName = "Verify the HRM Login page with Valid Username and Password",description = "Login feature",priority = 1,groups = "smoke test")
    public void loginTest(){
        extent.createTest("Verify the HRM Login page with Valid Username and Password")
               .log(Status.PASS, "Login feature, and it passed!");

    }
    @Test(testName = "Verify the HRM Login page with Invalid Username and Password",description = "Login feature",priority = 2,groups = "smoke test")
    public void loginTestwithInvalidUserName(){
        System.out.println("loginTest- tc2");
        extent.createTest("Verify the HRM Login page with Invalid Username and Password")
                .log(Status.FAIL, "Login feature, and it passed!");
    }
    @Test(testName = "Verify the HRM Login page with Invalid Username and Valid Password",description = "Login feature",priority = 3,groups = "smoke test")
    public void loginTestwithInvalidPassword(){
        System.out.println("loginTest- tc3");
        extent.createTest("Verify the HRM Login page with Invalid Username and Valid Password")
                .log(Status.PASS, "Login feature, and it passed!");
    }
    @Test(testName = "Verify the HRM Login page with Valid Username and Invalid Password",description = "Login feature",priority = 4,groups = "smoke test")
    public void loginTestwithInvalid(){
        System.out.println("loginTest- tc4");
        extent.createTest("Verify the HRM Login page with Valid Username and Invalid Password")
                .log(Status.PASS, "Login feature, and it passed!");
    }
    @Test(testName = "Verify the Forget password flow",description = "Forget Password feature",priority =4,groups = "smoke test")
    public void loginTestUnderTestDesign(){
        System.out.println("loginTest- tc5");
        extent.createTest("VVerify the Forget password flow")
                .log(Status.FAIL, "Login feature, and it passed!");
    }


    @AfterClass
    public void tearDownReport(){
        extent.flush();
    }



}
