import org.testng.annotations.Test;

public class LoginTestExample {



   @Test(testName = "Verify the HRM Login page with Valid Username and Password",description = "Login feature",priority = 1
           ,groups = "smoke test")
    public void loginTest(){
       System.out.println("loginTest- tc1");
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





}
