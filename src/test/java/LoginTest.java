import com.microsoft.playwright.Page;
import org.hrm.LoginPage;
import org.playwrightfactory.PlaywrightFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//1. TestLayer
public class LoginTest  {
    PlaywrightFactory pf ;
    Page page =null;
    LoginPage loginPage =null;
    @BeforeTest
    public void setup(){
        System.out.println("Base Test Class - setup Method");
        pf =  new PlaywrightFactory();
        Page page =pf.launchPlaywrightBrowser("chromium");
          loginPage = new LoginPage(page);
    }

   @Test(testName = "Verify the HRM Login page with Valid Username and Password",description = "Login feature",priority = 1
           ,groups = "smoke test")
    public void loginApp() throws Exception{
       String exceptedValue = "Dashboard";
       String acutalValue = loginPage.loginHRM("Admin","admin123");
       System.out.println("actual value is updated-- "+acutalValue);
       Assert.assertEquals(acutalValue,exceptedValue);

    }

    @AfterTest
    public void tearDown(){
        System.out.println("Base Test Class - tearDown Method");

    }
    }


