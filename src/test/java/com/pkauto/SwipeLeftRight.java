package com.pkauto;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeLeftRight extends BaseTest{

    @Test
    public void swipeRight() throws InterruptedException {
        //Actual script to execute
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
//        firstImage.click();
        Assert.assertEquals(firstImage.getAttribute("focusable"),"true");
        Thread.sleep(2000);
        swipeAction(firstImage,"left");

//        Assert.assertEquals(firstImage.getAttribute("focusable"),"false");
//        Thread.sleep(2000);
        
    }
}
