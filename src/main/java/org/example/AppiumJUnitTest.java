//package org.example;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.net.URL;
//
//public class AppiumJUnitTest {
//    private AppiumDriver<MobileElement> driver;
//
//    @BeforeEach
//    void setUp() throws Exception {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Pixel_4_Emulator");
//        capabilities.setCapability("app", "/path/to/your/app.apk");
//
//        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
//    }
//
//    @Test
//    void testLogin() {
//        MobileElement usernameField = driver.findElementById("com.example:id/username");
//        MobileElement passwordField = driver.findElementById("com.example:id/password");
//        MobileElement loginButton = driver.findElementById("com.example:id/login");
//
//        usernameField.sendKeys("testuser");
//        passwordField.sendKeys("password123");
//        loginButton.click();
//
//        MobileElement successMessage = driver.findElementById("com.example:id/successMessage");
//        Assertions.assertTrue(successMessage.isDisplayed(), "Login was unsuccessful!");
//    }
//
//    @AfterEach
//    void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
