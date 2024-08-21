package com.pkauto.pageObjects.android;

import com.pkauto.utils.AndroidActions;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage extends AndroidActions {

    AndroidDriver webDriver;

    //Constructor
    public FormPage (AndroidDriver driver) {

        super(driver);
        this.webDriver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id ="com.androidsample.generalstore:id/nameField" )
    private WebElement nameField;

    @FindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOption;

    @FindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    private WebElement maleOption;

    @FindBy(className = "android.widget.Spinner")
    private WebElement countrySelection;

    @AndroidBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")
    private WebElement selectValue;

    @FindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopBtn;


    public void setNameField (String name){
        nameField.sendKeys(name);
        webDriver.hideKeyboard();
    }

    public void setGender (String gender) {
        if (gender.contains("female")) {
            femaleOption.click();
        } else {
            maleOption.click();
        }
    }

    public void setActivity () {
        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");

        activity.setAppWaitPackage("com.androidsample.generalstore");
        activity.setAppWaitActivity("com.androidsample.generalstore.MainActivity");
//        driver.startActivity(activity);
//
//        ((JavascriptExecutor) driver).executeScript("mobile: startActivity",
//                ImmutableMap.of("intent", "com.androidsample.generalstore/io.appium.android.apis.preference.PreferenceDependencies"
//                ));


        webDriver.startActivity(activity);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.androidsample.generalstore:id/nameField")));

    }

    public void setCountrySelection(String countryName) throws InterruptedException {
        countrySelection.click();
        scrollToText(countryName);
        webDriver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
        Thread.sleep(3000);
    }

    public ProductCatalogue clickShopBtn () throws InterruptedException {
        letsShopBtn.click();
        Thread.sleep(3000);
        return new ProductCatalogue(webDriver);
    }

}
