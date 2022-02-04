import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void test1() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Target Practice");
    }

    @Test
    public void test2() {
        WebElement blackButton = driver.findElement(By.xpath("//*[contains(@class, 'black button')]"));
        Assert.assertEquals(blackButton.getText(), "black");
    }

    @Test(enabled = false)
    public void test3() {
        System.out.println("this test is skipped");
    }

    @Test
    public void test4() {
        throw new SkipException("this test is skipped using 'SkipException'");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
