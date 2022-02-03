import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement checkBox = driver.findElement(By.xpath("//*[@type='checkbox']"));

        System.out.println("is checkbox displayed on page: "+checkBox.isDisplayed());

        WebElement removeCheckbox = driver.findElement(By.xpath("//*[@id='toggleCheckbox']"));

        removeCheckbox.click();

        System.out.println("is checkbox displayed on page: "+checkBox.isDisplayed());

        driver.close();
    }
}
