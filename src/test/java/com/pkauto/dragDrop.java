package com.pkauto;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dragDrop extends BaseTest {

    @Test
    public void drapDropElement() throws InterruptedException {
        //Actual script to execute
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

        dragDrop(source, 620, 540);

        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(), "Dropped!");

    }
}
