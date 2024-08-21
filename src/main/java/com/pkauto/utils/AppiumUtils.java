package com.pkauto.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public abstract class AppiumUtils {

    public AppiumDriverLocalService service;
    public Double getFormattedAmount(String amount) {
        return Double.parseDouble(amount.substring(1));
    }

    public void waitForElement (WebElement ele, AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException {

        //System.getProperty("user.dir") + "src//test//java//com//pkauto//testData//eCommerce.json"
        //Convert json file content to Json String
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
    }

    public AppiumDriverLocalService startAppiumServer (String ipAddress, int port) {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\prabh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(ipAddress)
                .usingPort(port)
                .build();

        service.start();
        return service;
    }

    public String takeScreenshotPath(String TestCaseName, AppiumDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);

        String destinationFile = System.getProperty("user.dir")+"\\target\\extent-report"+TestCaseName+".png";

        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
}
