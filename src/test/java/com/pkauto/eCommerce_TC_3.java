package com.pkauto;


import com.pkauto.TestUtils.BaseTest;
import com.pkauto.utils.AndroidActions;
import org.testng.annotations.Test;

/*
 * Test Scenario : When you add two items in the cart
 * Sum of all the items is equal to Total cart value
 * */
public class eCommerce_TC_3 extends BaseTest {

    AndroidActions actions = new AndroidActions(driver);
    @Test
    public void addToCartSumTheCart() throws InterruptedException {

        formPage.setNameField("PKR");
        formPage.setGender("female");
        formPage.setCountrySelection("Argentina");
//        formPage.clickShopBtn();
        productCatalogue = formPage.clickShopBtn();

        Thread.sleep(4000);
        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0);

        cartPage = productCatalogue.goToCartPage();

        Thread.sleep(3000);



        cartPage.calculateCartValue();

//        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//        actions.longPressGesture(ele);
//        driver.findElement(By.id("android:id/button1")).click();
//
//        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
//        Thread.sleep(6000);
//
//        Set<String> contexts = driver.getContextHandles();
//
//        for (String contextHandle : contexts) {
//            System.out.println(contextHandle);
//        }
//
//        driver.context("WEBVIEW_com.androidsample.generalstore"); //for switching to web mode
//
//        WebElement googlQ = driver.findElement(By.name("q"));
//        wait.until(ExpectedConditions.visibilityOf(googlQ));
//        googlQ.sendKeys("A Airlines");
//        googlQ.sendKeys(Keys.ENTER);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), 'Including results for ')]"))));


    }
}
