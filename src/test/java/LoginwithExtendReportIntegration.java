
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginwithExtendReportIntegration {

    ExtentReports extent =null;
    ExtentSparkReporter spark = null;
   /* @BeforeClass
    public  void startTest()
    {
          extent = new ExtentReports();
          spark = new ExtentSparkReporter("target/Spark/Spark.html");

     }*/

   @Test(testName = "Verify the HRM Login page with Valid Username and Password",description = "Login feature",priority = 1
           ,groups = "smoke test")
    public void loginTest(){


        extent.createTest("Verify the HRM Login page with Valid Username and Password")
               .log(Status.PASS, "Login feature, and it passed!");

    }
    @Test(priority = 4,groups = "regression test")
    public void loginTestwithInvalidUserName(){
        System.out.println("loginTest- tc2");
    }
    @Test(priority = 3,groups = {"smoke test","regression test"})
    public void loginTestwithInvalidPassword(){
        System.out.println("loginTest- tc3");
    }
    @Test(priority = 2)
    public void loginTestwithInvalid(){
        System.out.println("loginTest- tc4");
    }
    @Test(priority = 5,enabled = false)
    public void loginTestUnderTestDesign(){
        System.out.println("loginTest- tc5");
    }


/*
@AfterClass
    public void tearDown(){

    extent.attachReporter(spark);
}
*/


}
