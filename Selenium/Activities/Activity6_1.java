import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement removeCheckbox = driver.findElement(By.xpath("//*[@id='toggleCheckbox']"));

        removeCheckbox.click();

        WebElement checkBox = driver.findElement(By.xpath("//*[@type='checkbox']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.invisibilityOf(checkBox));

        removeCheckbox.click();

        wait.until(ExpectedConditions.visibilityOf(checkBox));

        checkBox.click();

        driver.close();
    }
}
