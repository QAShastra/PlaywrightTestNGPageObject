import com.microsoft.playwright.Page;
import org.playwrightfactory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    Page page =null;

    @BeforeTest
    public void setup(){
        System.out.println("Base Test Class - setup Method");
       page =  PlaywrightFactory.launchPlaywrightBrowser("chromium");
    }
    @AfterTest
    public void tearDown(){
        System.out.println("Base Test Class - tearDown Method");

    }
}
