package com.pkauto;


import com.pkauto.TestUtils.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class eCommerce_TC_2 extends BaseTest {

    @Test(dataProvider = "getData",groups = {"Regression"})
    public void scrollToJordanShoe(HashMap<String, String> input) throws InterruptedException {

//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("PKR");
//        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
//        driver.findElement(By.className("android.widget.Spinner")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();


        formPage.setNameField(input.get("name"));
        formPage.setGender(input.get("gender"));
        formPage.setCountrySelection(input.get("country"));
        formPage.clickShopBtn();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
        //Finding the relevant cart of the selected Product.
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for (int i = 0; i < productCount; i++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"))));


    }

    @BeforeMethod(alwaysRun = true)
    public void preSetup() {

        formPage.setActivity();
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data;
        data = getJsonData("C:\\Users\\prabh\\OneDrive\\Documents\\GitHub\\appium-mobile-automation\\src\\test\\java\\com\\pkauto\\testData\\eCommerce.json");

        if(data.isEmpty()){
            throw new IOException("Data file empty or could not be read.");
        }
        return new Object[] [] {
                {data.getFirst()},
                {data.get(1)}
        };
    }
}
