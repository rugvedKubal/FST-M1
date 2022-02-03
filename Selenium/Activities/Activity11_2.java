import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement confirmationButton = driver.findElement(By.id("confirm"));
        confirmationButton.click();

        Alert confirm = driver.switchTo().alert();
        System.out.println("Text inside confirm box: "+confirm.getText());
        confirm.accept();

        confirmationButton.click();
        driver.switchTo().alert().dismiss();

        driver.close();
    }
}
