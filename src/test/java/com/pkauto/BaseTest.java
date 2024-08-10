package com.pkauto;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;


    public WebDriverWait wait;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
        //Android Driver
        // Appium Code > Appium Server > Mobile

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\prabh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel API 30"); //emulator
        options.setApp("C:\\Users\\prabh\\OneDrive\\Documents\\GitHub\\appium-mobile-automation\\src\\test\\java\\resources\\General-Store.apk");
        options.setAutomationName("UiAutomator2");
        options.setCapability("uiautomator2ServerLaunchTimeout", 60000);

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void longPressGesture(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) ele).getId(),
                        "duration", 2000
                ));
    }

    public void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) ele).getId(),
                        "direction", direction,
                        "percent", 0.75
                ));
    }

    public void dragDrop(WebElement ele, int x, int y) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) ele).getId(),
                        "endX", x,
                        "endY", y
                ));
    }

    public Double getFormattedAmount(String amount) {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
