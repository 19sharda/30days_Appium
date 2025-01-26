package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumSetupTest {
    public static void main(String[] args) throws Exception {
        // Set desired capabilities for the Android device and app
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "C:\\Users\\sp199\\IdeaProjects\\30days_Appium\\sunflower\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
        capabilities.setCapability("automationName", "UiAutomator2"); // This line is important
        capabilities.setCapability("uiautomator2ServerInstallTimeout", 60000);
        capabilities.setCapability("adbExecTimeout", 120000);  // Timeout in milliseconds (e.g., 2 minutes)


        // Platform Name (Android in this case)
        capabilities.setCapability("platformName", "Android");

        // Device Name (replace with your device/emulator name)
        capabilities.setCapability("deviceName", "emulator-5554"); // Or use your real device name

        // Path to your APK file (make sure it's correctly specified for your platform)
        capabilities.setCapability("app", "C:\\Users\\sp199\\IdeaProjects\\30days_Appium\\sunflower\\app\\build\\outputs\\apk\\debug\\app-debug.apk"); // Replace with the actual path

        // Specify the Appium server URL (should match the Appium server you started earlier)
        URL appiumServerUrl = new URL("http://127.0.0.1:4723/");

        // Create an instance of AndroidDriver to interact with the app
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, capabilities);

        // Add your test code here (you can perform actions on your app using the 'driver')
        System.out.println("App launched successfully!");

        // Quit the driver after the test
        driver.quit();
    }
}
