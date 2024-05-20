package org.example;

import org.testng.annotations.Test;

public class LoginPage extends DriverSetUp{
    @Test
    public void LoginPageOpen() throws InterruptedException {
        browser.get("https://carepro-training.ihmafrica.com");
        Thread.sleep(2000);
        System.out.println(browser.getTitle());
        System.out.println(browser.getCurrentUrl());
    }

}
