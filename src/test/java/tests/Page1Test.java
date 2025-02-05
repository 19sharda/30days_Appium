package tests;

import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Page1;

public class Page1Test {
    private Page1 page;

    @BeforeClass
    public void setup() {
        if (DriverManager.getDriver() == null) {
            throw new IllegalStateException("Driver is not initialized. Check DriverManager setup.");
        }
        page = new Page1(DriverManager.getDriver());
    }

    @Test(priority = 0)
    public void swipe() {
        page.swipe();
    }

    @Test(priority = 1)
    public void testScrollAndClick() {
        page.scrollToAndClickElement("Mango");
    }

    @Test(dependsOnMethods = "testScrollAndClick")
    public void testPrintPlantDescription() {
        page.printPlantDescription();
    }

    @AfterClass
    public void teardown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quitDriver();
        }
    }
}
