package com.pkauto;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/*
 * Test Scenario : When you add two items in the cart
 * Sum of all the items is equal to Total cart value
 * */
public class eCommerce_TC_3 extends BaseTest {

    @Test
    public void addToCartSumTheCart() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("PKR");
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.className("android.widget.Spinner")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).getFirst().click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).getFirst().click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"))));

        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")); //Getting all the webelemets of Price
        int count = productPrices.size();
        double sum = 0;
        for (WebElement productPrice : productPrices) {
            String amountString = productPrice.getText();
            Double price = getFormattedAmount(amountString);
            sum = sum + price;
        }

        String totalValue = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum = getFormattedAmount(totalValue);

        Assert.assertEquals(sum, displayFormattedSum);

        Thread.sleep(3000);

        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressGesture(ele);
        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);

        Set<String> contexts = driver.getContextHandles();

        for (String contextHandle : contexts) {
            System.out.println(contextHandle);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore"); //for switching to web mode

        WebElement googlQ = driver.findElement(By.name("q"));
        wait.until(ExpectedConditions.visibilityOf(googlQ));
        googlQ.sendKeys("A Airlines");
        googlQ.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), 'Including results for ')]"))));


    }
}
