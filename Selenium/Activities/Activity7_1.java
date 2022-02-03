import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-attributes");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement signInUsername = driver.findElement(By.xpath("//*[contains(@class, 'username-')]"));
        WebElement signInPassword = driver.findElement(By.xpath("//*[contains(@class, 'password-')]"));

        signInUsername.sendKeys("admin");
        signInPassword.sendKeys("password");

        WebElement loginButton = driver.findElement(By.xpath("//*[contains(text(), 'Log in')]"));

        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='action-confirmation']")));

        String loginMessage = driver.findElement(By.xpath("//*[@id='action-confirmation']")).getText();

        System.out.println("Login message is: "+loginMessage);

        driver.close();
    }
}
