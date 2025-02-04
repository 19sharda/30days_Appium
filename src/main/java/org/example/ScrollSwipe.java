package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ScrollSwipe {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 🌱 Clicking on 'Plant List' - It's like visiting a botanical garden, virtually
        WebElement plantList = driver.findElement(AppiumBy.accessibilityId("Plant list"));
        plantList.click();

        // 🌾 Confirming the 'Plant List' page is displayed
//        WebElement myPL = driver.findElement(By.xpath("//android.view.View[@content-desc='Plant list']"));
//        myPL.click();
//         SWAP
        WebElement srcElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='My garden']")));
        WebElement tgtElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Plant list']")));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(srcElement, tgtElement).perform();


        // Scroll: Using UiScrollable to find an element dynamically**

        WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Mango\").instance(0));"
        )));


        targetElement.click(); // Example action on found element
        WebElement plantDescription = driver.findElement(By.xpath("//android.widget.TextView[@text='Watering needs']/following-sibling::android.widget.TextView"));
        System.out.println("Watering needs: " + plantDescription.getText());


        // **W3C Scroll Gesture (Modern Scrolling)**
        scrollDown(driver);

        // 🛑 Closing the Appium driver
        driver.quit();
    }

    // 📌 **Modern Scrolling Using W3C Actions**
    public static void scrollDown(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }
}
