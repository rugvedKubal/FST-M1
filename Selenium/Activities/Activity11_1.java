import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement simpleAlertButton = driver.findElement(By.id("simple"));
        simpleAlertButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Text inside alert is: "+alert.getText());
        alert.accept();

        driver.close();
    }
}
