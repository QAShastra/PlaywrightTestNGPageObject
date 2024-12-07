package org.playwrightfactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

    public  static Page launchPlaywrightBrowser(String browerType) {
        Playwright playwright = Playwright.create();
        Browser browser = null;
        if (browerType.equals("chromium")) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        } else if (browerType.equals("firefox")) {
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        } else if (browerType.equals("webkit")) {
            browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
        }
        return browser.newPage();


    }
}
