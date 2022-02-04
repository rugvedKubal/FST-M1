import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity10 {

    WebDriver driver;
    Actions action;

    @BeforeTest
    public void setup() {
        Reporter.log("Setup Started");
        driver = new FirefoxDriver();
        Reporter.log("Opening Browser with link: https://www.training-support.net/selenium/sliders");
        driver.get("https://www.training-support.net/selenium/sliders");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        action = new Actions(driver);
    }

    @Test
    public void test1() {
        driver.findElement(By.id("slider")).click();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Middle value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "50");
    }

    @Test
    public void test2() {
        WebElement slider = driver.findElement(By.id("slider"));
        action.clickAndHold(slider).moveByOffset(75, 0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Max value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "100");
    }

    @Test
    public void test3() {
        WebElement slider = driver.findElement(By.id("slider"));
        action.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "0");
    }

    @Test
    public void test4() {
        WebElement slider = driver.findElement(By.id("slider"));
        action.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "30");
    }

    @Test
    public void test5() {
        WebElement slider = driver.findElement(By.id("slider"));
        action.clickAndHold(slider).moveByOffset(45, 0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "80");
    }

    @AfterTest
    public void tearDown() {
        Reporter.log("close the browser");
        driver.close();
    }
}
