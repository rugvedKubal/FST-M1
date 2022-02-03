import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/simple-form");

        System.out.println("title of the page is: "+driver.getTitle());

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement contactNumber = driver.findElement(By.id("number"));
        WebElement submitButton = driver.findElement(By.cssSelector(".ui.green.button"));

        firstName.sendKeys("John");
        lastName.sendKeys("Carter");
        email.sendKeys("john.carter@mail.com");
        contactNumber.sendKeys("1122334455");
        submitButton.click();

        driver.close();
    }
}
