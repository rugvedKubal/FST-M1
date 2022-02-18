package project;

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
import java.util.concurrent.TimeUnit;

public class GoogleKeepActivity {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.google.android.keep");
        capabilities.setCapability("appActivity", ".activities.BrowseActivity");
        capabilities.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<>(remoteUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void testGoogleKeep() {
        //click on "New Note" button
        driver.findElementById("new_note_button").click();
        //wait until new page appears to add note
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("editable_title")));
        //add Title
        driver.findElementById("editable_title").sendKeys("Appium Project");
        //add a note
        driver.findElementById("edit_note_text").sendKeys("Appium Project Notes");
        //click on Back button
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']").click();
        //scroll until the Note is displayed
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"Appium Project\")"));
        //get the status of the Note
        boolean isNoteDisplayed = driver.findElementByXPath("//androidx.cardview.widget.CardView[contains(@content-desc,'Appium Project. Appium Project Notes.')]").isDisplayed();
        //check if the Note is displayed
        Assert.assertTrue(isNoteDisplayed);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
