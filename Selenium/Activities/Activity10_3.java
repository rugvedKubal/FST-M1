import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10_3 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/drag-drop");

        System.out.println("title of the page is: " + driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));

        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.dragAndDrop(ball, dropzone1).build().perform();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='droppable']/p"), "Dropped!"));

        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        action.dragAndDrop(ball, dropzone2).build().perform();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='dropzone2']/p"), "Dropped!"));

        driver.close();
    }
}
