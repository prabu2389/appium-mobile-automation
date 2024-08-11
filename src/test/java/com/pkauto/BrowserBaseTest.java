package com.pkauto;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;


public class BrowserBaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;


    public WebDriverWait wait;


    @BeforeClass
    public void ConfigureAppium() throws URISyntaxException, MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\prabh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel API 30"); //emulator

        options.setChromedriverExecutable("C:\\Users\\prabh\\OneDrive\\Documents\\GitHub\\appium-mobile-automation\\src\\test\\java\\resources\\chromedriver 83");
        options.setCapability("browserName","Chrome");

//        options.setAutomationName("UiAutomator2");
//        options.setCapability("uiautomator2ServerLaunchTimeout", 60000);

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));


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
