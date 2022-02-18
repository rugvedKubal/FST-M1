package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity5 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "TestEmu");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.google.android.apps.messaging");
        capabilities.setCapability("appActivity", ".ui.ConversationListActivity");
        capabilities.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl, capabilities);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void test() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();

        String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(contactBoxLocator)));
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("1122334455");
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")));

        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")).sendKeys("Hello from Appium");

        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();

        String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(messageLocator)));

        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
