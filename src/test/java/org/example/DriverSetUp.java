package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetUp {
    public WebDriver browser;

    @BeforeSuite
    public void openABrowser() {
        String browserType = System.getProperty("browser", "chrome");

        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                browser = new ChromeDriver();
                break;
            case "safari":
                browser = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        browser.manage().window().maximize();
    }

    @AfterSuite
    public void quiteBrowser() {
        if (browser != null) {
            browser.quit();
        }
    }
}
