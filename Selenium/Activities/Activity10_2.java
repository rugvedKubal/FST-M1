import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/input-events");

        System.out.println("title of the page is: " + driver.getTitle());

        Actions action = new Actions(driver);
        action.sendKeys("R").perform();

        WebElement keyPressedElement = driver.findElement(By.id("keyPressed"));
        System.out.println("key pressed is: "+keyPressedElement.getText());

        action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        System.out.println("key pressed is: "+keyPressedElement.getText());

        driver.close();
    }
}
