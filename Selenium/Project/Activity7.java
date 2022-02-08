import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        driver.findElement(By.id("user_name")).sendKeys(username);
        driver.findElement(By.id("username_password")).sendKeys(password);
        driver.findElement(By.id("bigbutton")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("with-label")));

        boolean isProfileButtonDisplayed = driver.findElement(By.id("with-label")).isDisplayed();

        Assert.assertTrue(isProfileButtonDisplayed);
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void printLeadPhoneNumber() {
        WebElement salesMenu = driver.findElement(By.id("grouptab_0"));
        WebElement leadsMenuItem = driver.findElement(By.id("moduleTab_9_Leads"));

        actions = new Actions(driver);
        actions.moveToElement(salesMenu).moveToElement(leadsMenuItem).click(leadsMenuItem).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'table-responsive')]")));
        driver.findElement(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr[1]/descendant::*[contains(@class,'suitepicon-action-info')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-6")));
        String phoneNumber = driver.findElement(By.xpath("//*[contains(@id, 'ui-id-5')]/*[@class='phone']")).getText();

        System.out.println("Phone number of lead in first row of table is: "+phoneNumber);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}