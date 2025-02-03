package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;

import org.junit.Assert;


public class ClickTypingRetrieving {
    public static void main(String[] args) throws Exception {
        // 🚀 Setting up Appium - Because even robots need a GPS
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "YourPath/app-debug.apk");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("uiautomator2ServerInstallTimeout", 60000);
        capabilities.setCapability("adbExecTimeout", 120000);

        // 🎯 Connect to Appium server
        URL appiumServerUrl = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, capabilities);


        // 🌱 Clicking on 'Plant List' - It's like visiting a botanical garden, virtually
        WebElement plantList = driver.findElement(AppiumBy.accessibilityId("Plant list"));
        plantList.click();

        // 🌾 Confirming the 'Plant List' page is displayed
        WebElement myPL = driver.findElement(By.xpath("//android.view.View[@content-desc='Plant list']"));
        myPL.click();

        // 😴 Waiting for the user to admire the plant list
        Thread.sleep(5000);

        // 📷 Clicking on the first plant image using **advanced XPath**
        WebElement myPlant = driver.findElement(By.xpath("(//android.view.View[@content-desc='Picture of plant'])[1]"));
        myPlant.click();
        Thread.sleep(5000);
        WebElement plantDescription = driver.findElement(By.xpath("//android.widget.TextView[@text='Watering needs']/following-sibling::android.widget.TextView"));
        System.out.println("Fetch Watering needs: " + plantDescription.getText());

        // ✅ Example: Finding a specific element using contains()
        WebElement specialPlant = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Apple')]"));
        System.out.println("Verify Plant Found is APPLE: " + specialPlant.getText().trim().equals("Apple"));
        Assert.assertEquals("Guava", specialPlant.getText().trim());

        // 🎉 Success message
        System.out.println("App launched and tested successfully! 🌱");

        // 🛑 Closing the Appium driver
        driver.quit();
    }
}