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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleChromeActivity {

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

        driver = new AndroidDriver<>(remoteUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void testGoogleChrome() {
        List<String> expectedTasks = new ArrayList<>();
        expectedTasks.add("Add tasks to list");
        expectedTasks.add("Get number of tasks");
        expectedTasks.add("Clear the list");

        //scroll till 'To-Do List' and click it
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"To-Do List\")")).click();

        //wait until the To-Do List page loads
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text,'To-Do List')]")));

        //click on "Clear List" button before adding task
        driver.findElementByXPath("//android.widget.TextView[contains(@text,'Clear List')]").click();

        //Add all the expected tasks
        for(String taskName : expectedTasks) {
            //enter task
            driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys(taskName);
            //click on Add task button
            driver.findElementByXPath("//android.widget.Button[contains(@text,'Add Task')]").click();
        }

        //get the list of tasks
        List<MobileElement> tasks = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View/android.widget.TextView");

        //iterate through all tasks
        for(MobileElement task : tasks) {
            //get the task name
            String taskName = task.getText();
            //check if the task names matches with the tasks in 'expectedTask' list
            Assert.assertTrue(expectedTasks.contains(taskName));
        }

        //click on each task
        for(MobileElement task : tasks) {
            task.click();
        }

        //click on Clear List button
        driver.findElementByXPath("//android.widget.TextView[contains(@text,'Clear List')]").click();

        //get the list of tasks
        tasks = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']");
        //check if the list is empty (check if there are no tasks)
        Assert.assertTrue(tasks.isEmpty());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
