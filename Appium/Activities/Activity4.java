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

public class Activity4 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "TestEmu");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.android.contacts");
        capabilities.setCapability("appActivity", ".activities.PeopleActivity");
        capabilities.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl, capabilities);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void test() {
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Create new contact']").click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.EditText[@text='First name']")));

        driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aaditya");
        driver.findElementByXPath("//android.widget.EditText[@text='Last name']").sendKeys("Varma");
        driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("999148292");
        driver.findElementById("editor_menu_save_button").click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));

        MobileElement mobileCard = driver.findElementById("toolbar_parent");
        Assert.assertTrue(mobileCard.isDisplayed());

        String contactName = driver.findElementById("large_title").getText();
        System.out.println("Contact Name: "+contactName);
        Assert.assertEquals(contactName, "Aaditya Varma");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
