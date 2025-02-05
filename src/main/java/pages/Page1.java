package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page1 {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public Page1(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Fix PageFactory initialization
    }

    @AndroidFindBy(id = "com.example:id/username")
    private WebElement ac;

    @AndroidFindBy(accessibility = "Plant list")
    private WebElement plantList;

    // Swap Elements
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='My garden']")
    private WebElement srcElement;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Plant list']")
    private WebElement tgtElement;

    /**
     * Scroll and find an element dynamically using UiScrollable
     */
    public void scrollToAndClickElement(String text) {
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));"
                )
        ));
        targetElement.click();
    }

    /**
     * Extract and print plant description after clicking on it
     */
    public void printPlantDescription() {
        WebElement plantDescription = driver.findElement(By.xpath("//android.widget.TextView[@text='Watering needs']/following-sibling::android.widget.TextView"));
        System.out.println("Watering needs: " + plantDescription.getText());
    }

    /**
     * Perform login action & swap elements
     */
    public void swipe() {
        plantList.click();

        Actions actions = new Actions(driver);
        actions.dragAndDrop(srcElement, tgtElement).perform();
    }
}
