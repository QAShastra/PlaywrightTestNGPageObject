import org.testng.annotations.*;

public class Admin_UserMangt2 {


    @BeforeMethod
    public void loginpage(){
        System.out.println("Login into App");
    }

    @Test
    public void addANewUser(){
         System.out.println("adding a new user");
    }

    @Test
    public void deleteAUser(){
         System.out.println("deleting a existing user");
    }

    @Test void UpdateUserInfo(){
         System.out.println("updating a existing user");
    }

    @AfterMethod
    public void logoutApp(){
        System.out.println("logout into App");
    }
}
