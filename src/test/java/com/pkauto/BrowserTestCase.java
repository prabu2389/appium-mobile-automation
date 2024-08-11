package com.pkauto;

import org.testng.annotations.Test;

public class BrowserTestCase extends  BrowserBaseTest{

    @Test
    public void browserTest() {
        driver.get("www.yahoo.com");

        System.out.println(driver.getTitle());
    }
}
