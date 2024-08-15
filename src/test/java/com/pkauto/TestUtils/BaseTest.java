package com.pkauto.TestUtils;

import com.pkauto.pageObjects.android.CartPage;
import com.pkauto.pageObjects.android.FormPage;
import com.pkauto.pageObjects.android.ProductCatalogue;
import com.pkauto.utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest extends AppiumUtils {

    public AndroidDriver driver;
    public FormPage formPage;
    public ProductCatalogue productCatalogue;
    public CartPage cartPage;

    @BeforeClass
    public void ConfigureAppium() throws IOException, URISyntaxException {
        //Android Driver
        // Appium Code > Appium Server > Mobile

        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\prabh\\OneDrive\\Documents\\GitHub\\appium-mobile-automation\\src\\main\\resources\\data.properties");
        prop.load(fileInputStream);
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");
        String automationName = prop.getProperty("automationName");
        String AndroidDeviceName = prop.getProperty("AndroidDeviceName");
        String browser = prop.getProperty("browser");

        service = startAppiumServer (ipAddress,Integer.parseInt(port));

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(AndroidDeviceName); //emulator
        options.setApp("C:\\Users\\prabh\\OneDrive\\Documents\\GitHub\\appium-mobile-automation\\src\\test\\java\\resources\\General-Store.apk");
//        options.setCapability("browserName",browser);
        options.setAutomationName(automationName);
//        options.setCapability("chromedriverAutodownload", true); //Enable Automatic chromedriver download
        options.setCapability("uiautomator2ServerLaunchTimeout", 60000);

        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        formPage = new FormPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
