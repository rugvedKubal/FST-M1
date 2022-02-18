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

public class Activity3 {

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
    public void testAdd() {
        driver.findElementById("digit_5").click();
        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("digit_9").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println("result of (5 + 9) is: "+result);

        Assert.assertEquals(result, "14");
    }

    @Test
    public void testSub() {
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementByAccessibilityId("minus").click();
        driver.findElementById("digit_5").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println("result of (10 - 5) is: "+result);

        Assert.assertEquals(result, "5");
    }

    @Test
    public void testMul() {
        driver.findElementById("digit_5").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println("result of (5 * 100) is: "+result);

        Assert.assertEquals(result, "500");
    }

    @Test
    public void testDiv() {
        driver.findElementById("digit_5").click();
        driver.findElementById("digit_0").click();
        driver.findElementByAccessibilityId("divide").click();
        driver.findElementById("digit_2").click();
        driver.findElementById("eq").click();

        String result = driver.findElementById("result").getText();
        System.out.println("result of (50 / 2) is: "+result);

        Assert.assertEquals(result, "25");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
