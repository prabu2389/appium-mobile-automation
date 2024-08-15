package com.pkauto;


import com.pkauto.TestUtils.BaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class scrollTo extends BaseTest {

    @Test
    public void scrollToWebView() throws InterruptedException {
        //Actual script to execute
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        Thread.sleep(2000);

    }
}
