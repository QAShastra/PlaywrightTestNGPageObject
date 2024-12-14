package org.hrm;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
//2. PageLayer
public class LoginPage {
    private  Page page;
    // locator
    private String userName = "input[name='username']";
    private String passWord = "input[type='password']";
    private String loginButton = "button[type='submit']";

      // constructor
    public LoginPage(Page page){
        this.page = page;
    }
   /* public void loadingHRMLoginPage() {
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
*/
    public String loginHRM(String username, String password) {
        page.locator(userName).fill(username);
        page.locator(passWord).fill(password);
        page.locator(loginButton).click();

       String actualText = page.locator("//h6[text()='Dashboard']").textContent();

       return actualText;
    }


}
