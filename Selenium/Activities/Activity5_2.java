import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement checkBox = driver.findElement(By.xpath("//*[@type='checkbox']"));

        System.out.println("is checkbox selected: "+checkBox.isSelected());

        checkBox.click();

        System.out.println("is checkbox selected: "+checkBox.isSelected());

        driver.close();
    }
}
