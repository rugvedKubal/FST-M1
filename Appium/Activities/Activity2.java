package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "TestEmu");
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
        driver.get("https://www.training-support.net/");
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[@text='About Us']")));

        String title = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
        System.out.println("Title on Homepage: " + title);

        driver.findElementByXPath("//android.view.View[@text='About Us']").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@text='About Us']")));
        String newPageTitle = driver.findElementByXPath("//android.view.View[@text='About Us']").getText();
        System.out.println("Title on new page: " + newPageTitle);

        Assert.assertEquals(title, "Training Support");
        Assert.assertEquals(newPageTitle, "About Us");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
