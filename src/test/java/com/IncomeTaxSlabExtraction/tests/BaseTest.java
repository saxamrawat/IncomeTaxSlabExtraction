package com.IncomeTaxSlabExtraction.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;
    protected final String base_url = "https://www.incometax.gov.in/iec/foportal/";

    @BeforeTest
    public void DriverSetup(){
        driver = new ChromeDriver();
        driver.get(base_url);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
