package com.IncomeTaxSlabExtraction.pages;

import org.openqa.selenium.WebDriver;

public class IncomeTaxHomePage {

    private WebDriver driver;

    public IncomeTaxHomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

}
