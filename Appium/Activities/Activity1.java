package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "TestEmu");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");
        capabilities.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl, capabilities);
    }

    @Test
    public void testCalc() {
        driver.findElementById("digit_7").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementById("digit_3").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println("result of (7 * 3) is: "+result);

        Assert.assertEquals(result, "21");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
