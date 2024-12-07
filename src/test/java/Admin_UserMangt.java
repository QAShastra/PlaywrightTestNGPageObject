import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Admin_UserMangt {


    @BeforeTest
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

    @AfterTest
    public void logoutApp(){
        System.out.println("logout into App");
    }
}
