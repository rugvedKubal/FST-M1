package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Activity6 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl, capabilities);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void test() {
        driver.get("https://www.training-support.net/selenium/lazy-loading");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'Lazy Loading')]")));

        List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());

        Assert.assertEquals(numberOfImages.size(), 2);

        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"helen\")"));

        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());

        Assert.assertEquals(numberOfImages.size(), 3);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
