package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class ControlEmulator {
    public static void main(String[] args) throws Exception {
        // Set desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "C:\\Users\\sp199\\IdeaProjects\\30days_Appium\\sunflower\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("uiautomator2ServerInstallTimeout", 60000);
        capabilities.setCapability("adbExecTimeout", 120000);

        // Connect to Appium server
        URL appiumServerUrl = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, capabilities);

        // Launch app
        System.out.println("App launched successfully!");
        driver.quit();
    }
}
