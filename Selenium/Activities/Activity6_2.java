import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/ajax");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement changeContentButton = driver.findElement(By.xpath("//*[contains(@class, 'violet button')]"));

        changeContentButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));

        String helloText = driver.findElement(By.id("ajax-content")).getText();

        System.out.println("text displayed: "+helloText);

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));

        String lateText = driver.findElement(By.id("ajax-content")).getText();

        System.out.println("text displayed: "+lateText);

        driver.close();
    }
}
