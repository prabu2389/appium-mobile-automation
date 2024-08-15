package com.pkauto.pageObjects.android;

import com.pkauto.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CartPage extends AndroidActions {

    AndroidDriver webDriver;
    FormPage formPage;
    ProductCatalogue productCatalogue;

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.webDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @FindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List <WebElement> productPrices;

    @FindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;

    @AndroidFindBy (id = "")
    private WebElement terms;

    @AndroidFindBy (id = "")
    private WebElement acceptButton;

    @AndroidFindBy (id = "")
    private WebElement proceed;

    @AndroidFindBy (className = "")
    private WebElement Checkbox;


    public List<WebElement> getProductPrices() {
        return productPrices;
    }

    public double getProductsSum() {
        int count = productPrices.size();
        double sum = 0;
        for (WebElement productPrice : productPrices) {
            String amountString = productPrice.getText();
            Double price = getFormattedAmount(amountString);
            sum = sum + price;
        }
        return sum;
    }

    public double totalAmountDisplayed () {
        return getFormattedAmount(totalAmount.getText());
    }

    public void calculateCartValue () throws InterruptedException {

        Assert.assertEquals(getProductsSum(), totalAmountDisplayed());

        Thread.sleep(3000);
        }
}
