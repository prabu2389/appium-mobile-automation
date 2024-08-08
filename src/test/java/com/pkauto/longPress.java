package com.pkauto;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class longPress extends BaseTest{

    @Test
    public void LongPressGesture() throws InterruptedException {
        //Actual script to execute
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        longPressGesture(ele);

        Thread.sleep(2000);

        String menuText = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(menuText,"Sample menu");
        
    }
}
