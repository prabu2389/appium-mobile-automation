package com.pkauto;


import com.pkauto.TestUtils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class eCommerce_TC_1 extends BaseTest {


    @Test(dataProvider = "getData")
    public void fillForm(HashMap<String, String> input) throws InterruptedException {

//        FormPage formPage = new FormPage(driver);
        formPage.setNameField(input.get("name"));
        formPage.setGender(input.get("gender"));
        formPage.setCountrySelection(input.get("country"));
        formPage.clickShopBtn();
//        Thread.sleep(3000);

        //Toast messages - Error message display for few seconds in Application.

//        String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//        Assert.assertEquals(toastMsg, "Please enter your name");
//
//        Thread.sleep(3000);


    }

    @BeforeMethod
    public void preSetup() {

        formPage.setActivity();
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data;
        data = getJsonData("C:\\Users\\prabh\\OneDrive\\Documents\\GitHub\\appium-mobile-automation\\src\\test\\java\\com\\pkauto\\testData\\eCommerce.json");

        return new Object[] [] {
                {data.getFirst()},
                {data.get(1)}
        };
    }
}
