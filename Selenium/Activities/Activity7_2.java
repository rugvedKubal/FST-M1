import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-attributes");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement signUpUsername = driver.findElement(By.xpath("//*[contains(@class, '-username')]"));
        WebElement signUpPassword = driver.findElement(By.xpath("//*[contains(@class, '-password')]"));
        WebElement signUpConfirmPassword = driver.findElement(By.xpath("//*[contains(text(), 'Confirm Password')]/following-sibling::input"));
        WebElement signUpEmail = driver.findElement(By.xpath("//*[contains(@class, 'email-')]"));
        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]"));

        signUpUsername.sendKeys("John");
        signUpPassword.sendKeys("password");
        signUpConfirmPassword.sendKeys("password");
        signUpEmail.sendKeys("john@mail.com");
        signUpButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='action-confirmation']")));

        String message = driver.findElement(By.xpath("//*[@id='action-confirmation']")).getText();

        System.out.println("message displayed is: "+message);

        driver.close();
    }
}
