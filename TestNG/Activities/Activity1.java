import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }

    @Test
    public void test1() {
        String title = driver.getTitle();
        System.out.println("title of page is: "+title);
        Assert.assertEquals(title, "Training Support");

        driver.findElement(By.id("about-link")).click();
        String newPageTitle = driver.getTitle();
        System.out.println("title of new page is: "+newPageTitle);
        Assert.assertEquals(newPageTitle, "About Training Support");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
