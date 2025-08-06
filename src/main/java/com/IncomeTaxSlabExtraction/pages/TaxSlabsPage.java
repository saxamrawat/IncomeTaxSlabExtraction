package com.IncomeTaxSlabExtraction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaxSlabsPage {

    private WebDriver driver;

    private By slabTableLocator = By.xpath("//span[text()='Tax rates for Individual (resident or non-resident) less than 60 years of age anytime during the previous year are as under:']/ancestor::ol/following-sibling::table[1]");

    // --- Constructor ---
    public TaxSlabsPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Action Methods ---

    public List<Map<String, String>> extractOldRegimeData() {
        System.out.println("Extracting OLD Regime Tax Slabs...");
        return extractDataFromColumns(0, 1, 2);
    }


    public List<Map<String, String>> extractNewRegimeData() {
        System.out.println("Extracting NEW Regime Tax Slabs...");
        return extractDataFromColumns(3, 4, 5);
    }

    private List<Map<String, String>> extractDataFromColumns(int slabCol, int rateCol, int surchargeCol) {
        List<Map<String, String>> slabData = new ArrayList<>();
        WebElement individualSlabTable = driver.findElement(slabTableLocator);
        List<WebElement> rows = individualSlabTable.findElements(By.tagName("tr"));

        // Skip header rows, start from the first data row.
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));

            // Ensure the row has enough columns for the regime we're reading
            if (cols.size() > surchargeCol) {
                String incomeSlab = cols.get(slabCol).getText().trim();
                String taxRate = cols.get(rateCol).getText().trim();
                String surcharge = cols.get(surchargeCol).getText().trim();

                // Only add rows that actually contain slab information
                if (incomeSlab != null && !incomeSlab.isEmpty()) {
                    Map<String, String> rowData = new LinkedHashMap<>();
                    rowData.put("Income Slab", incomeSlab);
                    rowData.put("Tax Rate", taxRate);
                    rowData.put("Surcharge", surcharge);
                    slabData.add(rowData);
                }
            }
        }
        return slabData;
    }
}