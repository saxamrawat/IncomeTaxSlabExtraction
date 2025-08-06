package com.IncomeTaxSlabExtraction.tests;

import com.IncomeTaxSlabExtraction.pages.IncomeTaxHomePage;
import com.IncomeTaxSlabExtraction.pages.TaxSlabsPage;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;
import java.util.Map;

public class TaxSlabExtractorTest extends BaseTest {

    @Test
    public void checkSlab(){
        IncomeTaxHomePage homePage = new IncomeTaxHomePage(driver);
        TaxSlabsPage slabsPage = homePage.getSalariedIndividualTaxSlabs();
        List<Map<String, String>> oldTaxData = slabsPage.extractOldRegimeData();

        // Verification 1: Ensure data was extracted
        Assert.assertFalse(oldTaxData.isEmpty(), "Extracted tax slab data should not be empty.");

//        System.out.println("\n--- Extracted Tax Slab Data (A.Y. 2025-26) ---");
        for (Map<String, String> row : oldTaxData) {
            System.out.println(row.get("Income Slab") + "  =>  " + row.get("Tax Rate"));
        }
        System.out.println("----------------------------------------------\n");

        List<Map<String, String>> newTaxData = slabsPage.extractNewRegimeData();

        // Verification 1: Ensure data was extracted
        Assert.assertFalse(newTaxData.isEmpty(), "Extracted tax slab data should not be empty.");

//        System.out.println("\n--- Extracted Tax Slab Data (A.Y. 2025-26) ---");
        for (Map<String, String> row : newTaxData) {
            System.out.println(row.get("Income Slab") + "  =>  " + row.get("Tax Rate"));
        }
        System.out.println("----------------------------------------------\n");
    }
}
