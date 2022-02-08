import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void printHeaderLogoUrl() {
        String headerLogoUrl = driver.findElement(By.xpath("//*[@class='companylogo']/img")).getAttribute("src");
        System.out.println("Header logo URL is: "+headerLogoUrl);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
