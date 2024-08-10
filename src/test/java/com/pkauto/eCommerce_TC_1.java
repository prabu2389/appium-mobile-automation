package com.pkauto;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_TC_1 extends BaseTest {

    @Test
    public void fillForm() throws InterruptedException {

//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("PKR");
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.className("android.widget.Spinner")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//        Thread.sleep(3000);

        //Toast messages

        String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMsg, "Please enter your name");

        Thread.sleep(3000);


    }
}
