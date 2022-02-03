import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/input-events");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement cube = driver.findElement(By.id("wrapD3Cube"));

        Actions action = new Actions(driver);
        action.click(cube);
        WebElement currentCube = driver.findElement(By.className("active"));
        System.out.println("Displayed side of the cube after left click is: "+currentCube.getText());

        action.doubleClick(cube).perform();
        currentCube = driver.findElement(By.className("active"));
        System.out.println("Displayed side of the cube after double click is: "+currentCube.getText());

        action.contextClick(cube).perform();
        currentCube = driver.findElement(By.className("active"));
        System.out.println("Displayed side of the cube after right click is: "+currentCube.getText());

        driver.close();
    }
}
