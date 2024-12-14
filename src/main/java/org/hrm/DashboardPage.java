package org.hrm;

import com.microsoft.playwright.Page;

public class DashboardPage {

    Page page;

    //constructor
    public DashboardPage(Page page){
        this.page = page;
    }

    String Admin = "(//a[@class='oxd-main-menu-item']//span)[1]";
    String PIM = "(//span[contains(@class,'oxd-text oxd-text--span')])[2]";
    String Leave = "(//a[@class='oxd-main-menu-item']//span)[2]";
    String Time = "(//a[@class='oxd-main-menu-item']//span)[3]";
    String Recruitment = "//span[text()='Recruitment']";
    String MyInfo = "//span[text()='My Info']";
    String Performance = "//span[text()='Performance']";
    String Dashboard = "//span[text()='Dashboard']";
    String Directory = "//span[text()='Directory']";
    String Maintenance = "//span[text()='Maintenance']";
    String Claim = "//span[text()='Claim']";
    String Buzz = "//span[text()='Buzz']";
    String txtPIM ="//h6[text()='PIM']";
    public String navigateToAdmin() throws InterruptedException {
        page.locator(Admin).click();
        String actualText;
        actualText = page.locator("//h6[text()='User Management']").textContent();
        Thread.sleep(1000);
        return actualText;
    }
    public String navigateToPIM(){
        page.locator(PIM).click();
       return page.locator(txtPIM).textContent();

    }
    public void navigateToLeave() {
        page.locator(Leave).click();
    }
    public void navigateToTime() {
        page.locator(Time).click();
    }
    public void navigateToRecruitment() {
        page.locator(Recruitment).click();
    }
    public void navigateToMyInfo() {
        page.locator(MyInfo).click();
    }
    public void navigateToPerformance() {
        page.locator(Performance).click();
    }
    public void navigateToDashboard() {
        page.locator(Dashboard).click();
    }
    public void navigateToDirectory() {
        page.locator(Directory).click();
    }
    public void navigateToMaintenance() {
        page.locator(Maintenance).click();
    }
    public void navigateToClaim() {
        page.locator(Claim).click();
    }
    public void navigateToBuzz() {
        page.locator(Buzz).click();
    }

}
