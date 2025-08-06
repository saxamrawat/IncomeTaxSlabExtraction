package com.IncomeTaxSlabExtraction.tests;

import com.IncomeTaxSlabExtraction.pages.IncomeTaxHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class IncomeTaxHomePageTest extends BaseTest {

    @Test
    public void checkTitle(){
        IncomeTaxHomePage homePage = new IncomeTaxHomePage(driver);

        String expected = "Home | Income Tax Department";

        String actual = homePage.getPageTitle();

        Assert.assertEquals(expected,actual, "The title does not match the page");
    }
}
