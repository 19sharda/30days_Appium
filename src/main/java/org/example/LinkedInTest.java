package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class LinkedInTest { // ✅ Renamed class to avoid conflict
    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "XXXXX"); // Use `adb devices` to find it
        caps.setCapability("appPackage", "com.linkedin.android");
        caps.setCapability("appActivity", "com.linkedin.android.authenticator.LaunchActivityDefault");
        caps.setCapability("automationName", "UiAutomator2");

        // ✅ No generic type for AndroidDriver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);

        // ✅ Find login button and click it
        WebElement loginBtn = driver.findElement(By.id("com.linkedin.android:id/login"));
        loginBtn.click();

        System.out.println("Login button clicked successfully!");

        driver.quit();
    }
}
