import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_3 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement promptButton = driver.findElement(By.id("prompt"));
        promptButton.click();

        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("Hello!");
        prompt.accept();

        driver.close();
    }
}
