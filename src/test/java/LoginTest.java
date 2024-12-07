import org.hrm.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
//1. TestLayer
public class LoginTest extends BaseTest {



   @Test(testName = "Verify the HRM Login page with Valid Username and Password",description = "Login feature",priority = 1
           ,groups = "smoke test")
    public void loginApp() throws Exception{
       String exceptedValue = "Dashboard";
       LoginPage loginPage = new LoginPage(page);
       loginPage.loadingHRMLoginPage();
       String acutalValue = loginPage.loginHRM("Admin","admin123");
       System.out.println("actual value is updated-- "+acutalValue);
       Assert.assertEquals(acutalValue,exceptedValue);

    }

    }


