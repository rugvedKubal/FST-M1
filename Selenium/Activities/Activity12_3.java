import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12_3 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.training-support.net/selenium/popups");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement signInButton = driver.findElement(By.xpath("//button[contains(@class, 'orange')]"));

        Actions action = new Actions(driver);
        action.moveToElement(signInButton).pause(Duration.ofSeconds(2)).build().perform();
        String toolTipTextOfButton = signInButton.getAttribute("data-tooltip");
        System.out.println("Text inside tool tip of Sign in button is: "+toolTipTextOfButton);

        signInButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("displayed message is: "+message);

        driver.close();
    }
}
