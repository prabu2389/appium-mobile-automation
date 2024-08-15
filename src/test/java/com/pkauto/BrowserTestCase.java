package com.pkauto;

import com.pkauto.TestUtils.BrowserBaseTest;
import org.testng.annotations.Test;

public class BrowserTestCase extends BrowserBaseTest {

    @Test
    public void browserTest() {
        driver.get("http://www.yahoo.com");

        System.out.println(driver.getTitle());
    }
}
