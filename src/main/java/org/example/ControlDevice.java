package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class ControlDevice {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "YOUR_DEVICE"); // Use `adb devices` to find it
        caps.setCapability("appPackage", "com.linkedin.android");
        caps.setCapability("appActivity", "com.linkedin.android.authenticator.LaunchActivityDefault");
        caps.setCapability("automationName", "UiAutomator2");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        System.out.println("App launched on a real device! 🎉");
        driver.quit();
    }
}
