package com.pkauto;


import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

public class appiumBasics extends BaseTest {

    @Test
    public void WifiSettingsName() {

        driver.rotate(ScreenOrientation.PORTRAIT);
        //Actual script to execute
//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(AppiumBy.
//                xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
//        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
//
//        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).isEnabled();
//        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
//
//
////        DeviceRotation landscape = new DeviceRotation(0,0,90);
////        driver.rotate(landscape);
//        //CopyPast
//        //Copy to Clipboard - Paste it clipboard
//        driver.setClipboardText("123456");
//        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
//
//        driver.findElement(AppiumBy.id("android:id/button1")).click();

    }
}
