import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity9 {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        Reporter.log("Setup Started");
        driver = new FirefoxDriver();
        Reporter.log("Opening Browser with link: https://www.training-support.net/selenium/javascript-alerts");
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void getBackToMainPage() {
        Reporter.log("In 'BeforeMethod' : Switching back to main page");
        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTestCase() {
        Reporter.log("In 'Test' -> 'simpleAlertTestCase'");
        Reporter.log("Click on 'Simple Alert' button");
        driver.findElement(By.id("simple")).click();
        Reporter.log("Switch to alert");
        Alert alert = driver.switchTo().alert();
        Reporter.log("Alert message: "+alert.getText());
        Reporter.log("Click on 'ok' button");
        alert.accept();
    }

    @Test
    public  void confirmAlertTestCase() {
        Reporter.log("In 'Test' -> 'confirmAlertTestCase'");
        Reporter.log("Click on 'Confirmation' button");
        driver.findElement(By.id("confirm")).click();
        Reporter.log("Switch to alert");
        Alert confirm = driver.switchTo().alert();
        Reporter.log("Confirm message: "+confirm.getText());
        Reporter.log("Click on 'cancel' button");
        confirm.dismiss();
    }

    @Test
    public void promptAlertTestCase() {
        Reporter.log("In 'Test' -> 'promptAlertTestCase'");
        Reporter.log("Click on 'Prompt' button");
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Switch to alert");
        Alert prompt = driver.switchTo().alert();
        Reporter.log("Prompt message: "+prompt.getText());
        Reporter.log("enter 'Hello!' in prompt");
        prompt.sendKeys("Hello!");
        Reporter.log("Click on 'ok' button");
        prompt.accept();
    }

    @AfterTest
    public void tearDown() {
        Reporter.log("close the browser");
        driver.close();
    }
}
