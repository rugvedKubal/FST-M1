import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement textBox = driver.findElement(By.xpath("//*[@id='input-text']"));

        System.out.println("is text box enabled: "+textBox.isEnabled());

        WebElement enableInputButton = driver.findElement(By.xpath("//*[@id='toggleInput']"));

        enableInputButton.click();

        System.out.println("is text box enabled: "+textBox.isEnabled());

        driver.close();
    }
}
