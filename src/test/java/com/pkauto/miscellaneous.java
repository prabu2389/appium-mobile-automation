package com.pkauto;


import com.google.common.collect.ImmutableMap;
import com.pkauto.TestUtils.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

public class miscellaneous extends BaseTest {

    @Test
    public void miscellaneousActions() {

        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");

        ((JavascriptExecutor) driver).executeScript("mobile: startActivity",
                ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
                ));


//        adb shell dumpsys window | find "mCurrentFocus"
//
//        mCurrentFocus=Window{d17e535 u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
//
//        mCurrentFocus=Window{d17e535 u0 io.appium.android.apis - Package Name
//            io.appium.android.apis.preference.PreferenceDependencies} - Activity Name

        driver.rotate(ScreenOrientation.PORTRAIT);
        //Actual script to execute
//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(AppiumBy.
//                xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).isEnabled();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();


//        DeviceRotation landscape = new DeviceRotation(0,0,90);
//        driver.rotate(landscape);
        //CopyPast
        //Copy to Clipboard - Paste it clipboard
        driver.setClipboardText("123456");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());

        driver.findElement(AppiumBy.id("android:id/button1")).click();

    }
}
