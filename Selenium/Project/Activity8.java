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

public class Activity8 {

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
    public void printAccountNames() {
        WebElement salesMenu = driver.findElement(By.id("grouptab_0"));
        WebElement accountsMenuItem = driver.findElement(By.id("moduleTab_9_Accounts"));

        actions = new Actions(driver);
        actions.moveToElement(salesMenu).moveToElement(accountsMenuItem).click(accountsMenuItem).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'table-responsive')]")));

        for (int i = 1; i <= 9; i=i+2){
            String name = driver.findElement(By.xpath("//table[contains(@class, 'table-responsive')]/tbody/tr["+i+"]/td[3]/descendant::a")).getText();
            System.out.println("Name on row "+i+" : "+name);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
