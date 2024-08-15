package com.pkauto.pageObjects.android;

import com.pkauto.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AndroidActions {

    AndroidDriver webDriver;

    FormPage formPage;

    public ProductCatalogue(AndroidDriver driver) {
        super(driver);
        this.webDriver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private List<WebElement> addToCart;

    @FindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;

    public void addItemToCartByIndex (int index) {
//        addToCart.get(index).click();

        int productCount = addToCart.size();
        for (index = 0; index < productCount; index++) {
            addToCart.get(index).click();
        }

    }

    public CartPage goToCartPage() throws InterruptedException {
        cart.click();
        Thread.sleep(2000);
        return new CartPage(webDriver);
    }
}
