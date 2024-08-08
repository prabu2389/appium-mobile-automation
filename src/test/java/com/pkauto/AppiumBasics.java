package com.pkauto;


import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class appiumBasics extends BaseTest{

    @Test
    public void WifiSettingsName() {
        //Actual script to execute
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.
                xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).isEnabled();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("123456");
        driver.findElement(AppiumBy.id("android:id/button1")).click();

    }
}
