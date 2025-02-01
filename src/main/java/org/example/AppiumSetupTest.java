package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;

public class AppiumSetupTest {
    public static void main(String[] args) throws Exception {
        // Set desired capabilities for the Android device and app
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "C:\\Your_Path\\app-debug.apk");
        capabilities.setCapability("automationName", "UiAutomator2"); // This line is important
        capabilities.setCapability("uiautomator2ServerInstallTimeout", 60000);
        capabilities.setCapability("adbExecTimeout", 120000);  // Timeout in milliseconds (e.g., 2 minutes)

        // Specify the Appium server URL (should match the Appium server you started earlier)
        URL appiumServerUrl = new URL("http://127.0.0.1:4723/");

        // Create an instance of AndroidDriver to interact with the app
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, capabilities);

        WebElement myGarden = driver.findElement(By.xpath("//android.view.View[@content-desc='My garden']"));
        myGarden.click();
        List<WebElement> textViews = driver.findElements(By.className("android.widget.TextView"));
        for (WebElement tv : textViews) {
            System.out.println(tv.getText());
        }

        WebElement plantList = driver.findElement(AppiumBy.accessibilityId("Plant list"));
        plantList.click();


        // Add your test code here (you can perform actions on your app using the 'driver')
        System.out.println("App launched successfully!");

        // Quit the driver after the test
        driver.quit();
    }
}



