import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/simple-form");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
        WebElement email = driver.findElement(By.xpath("//*[@id='email']"));
        WebElement contactNumber = driver.findElement(By.xpath("//*[@id='number']"));
        WebElement message = driver.findElement(By.xpath("//textarea"));
        WebElement submitButton = driver.findElement(By.xpath("//*[contains(@class,'green button')]"));

        firstName.sendKeys("John");
        lastName.sendKeys("Carter");
        email.sendKeys("john1.carter@mail.com");
        contactNumber.sendKeys("1122334455");
        message.sendKeys("some message");
        submitButton.click();
    }

}
