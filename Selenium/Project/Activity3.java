import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity3 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void printFirstCopyrightText() {
        String firstCopyrightText = driver.findElement(By.id("admin_options")).getText();
        System.out.println("First copyright text is: "+firstCopyrightText);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
