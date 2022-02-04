import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test(groups = {"HeaderTests", "ButtonTests"})
    public void test1() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Target Practice");
    }

    @Test(groups = {"HeaderTests"})
    public void headerTest1() {
        String thirdHeaderText = driver.findElement(By.id("third-header")).getText();
        Assert.assertEquals(thirdHeaderText, "Third header");
    }

    @Test(groups = {"HeaderTests"})
    public void headerTest2() {
        String colorValue = driver.findElement(By.xpath("//*[contains(@class, 'green header')]")).getCssValue("color");
        Assert.assertEquals(colorValue, "rgb(33, 186, 69)");
    }

    @Test(groups = {"ButtonTests"})
    public void buttonTest1() {
        String oliveButtonText = driver.findElement(By.xpath("//*[contains(@class, 'olive button')]")).getText();
        Assert.assertEquals(oliveButtonText, "Olive");
    }

    @Test(groups = {"ButtonTests"})
    public void buttonTest2() {
        String colorValue = driver.findElement(By.xpath("//*[contains(@class, 'brown button')]")).getCssValue("color");
        Assert.assertEquals(colorValue, "rgb(255, 255, 255)");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}
