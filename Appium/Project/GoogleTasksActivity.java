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

public class GoogleTasksActivity {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.google.android.apps.tasks");
        capabilities.setCapability("appActivity", ".ui.TaskListsActivity");
        capabilities.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<>(remoteUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void testGoogleTasks() {
        //create new list to add expected tasks
        List<String> expectedTasks = new ArrayList<>();
        //add the expected tasks to the list
        expectedTasks.add("Complete Activity with Google Tasks");
        expectedTasks.add("Complete Activity with Google Keep");
        expectedTasks.add("Complete the second Activity Google Keep");

        //Add all the tasks in the app
        for(String taskName : expectedTasks) {
            //click on 'New Tasks' button
            driver.findElementById("tasks_fab").click();
            //wait until the "New Task" text input field is displayed
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("add_task_title")));
            //add task
            driver.findElementById("add_task_title").sendKeys(taskName);
            //click on save
            driver.findElementById("add_task_done").click();
        }

        //get the actual list of tasks from app
        List<MobileElement> tasks = driver.findElementsById("com.google.android.apps.tasks:id/task_name");

        //iterate through each task
        for(MobileElement task : tasks) {
            //get the task name
            String taskName = task.getText();
            //check if the task name is not empty
            if(!taskName.isEmpty()) {
                //check if the task names matches with the tasks in 'expectedTask' list
                Assert.assertTrue(expectedTasks.contains(taskName));
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
