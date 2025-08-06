package com.IncomeTaxSlabExtraction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IncomeTaxHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public IncomeTaxHomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public TaxSlabsPage getSalariedIndividualTaxSlabs(){
        Actions actions = new Actions(driver);
        WebElement individualMenu = driver.findElement(By.xpath("//a[text()='Individual/HUF']"));
        actions.moveToElement(individualMenu).perform();

        WebElement salariedEmployeesSubMenu = driver.findElement(By.xpath("//a[text()='Salaried Employees']"));
        wait.until(ExpectedConditions.visibilityOf(salariedEmployeesSubMenu));
        actions.moveToElement(salariedEmployeesSubMenu).perform();

        WebElement taxSlabElementOption = driver.findElement(By.xpath("(//a[text()='Tax slabs'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(taxSlabElementOption)).click();

        return new TaxSlabsPage(driver);
    }
}
