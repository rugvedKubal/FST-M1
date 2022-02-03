import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Activity12_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.training-support.net/selenium/iframes");

        System.out.println("title of the page is: " + driver.getTitle());

        driver.switchTo().frame(0);

        String frame1Heading = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("Frame 1 heading is: "+frame1Heading);

        WebElement button = driver.findElement(By.cssSelector("button"));
        System.out.println("Button text is: "+button.getText());
        System.out.println("Button color is: "+button.getCssValue("background-color"));
        button.click();

        System.out.println("new button text is: "+button.getText());
        System.out.println("new button color is: "+button.getCssValue("background-color"));

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        String frame2Heading = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("Frame 2 heading is: "+frame2Heading);

        WebElement button2 = driver.findElement(By.cssSelector("button"));
        System.out.println("Button 2 text is: "+button2.getText());
        System.out.println("Button 2 color is: "+button2.getCssValue("background-color"));
        button2.click();

        System.out.println("new button 2 text is: "+button2.getText());
        System.out.println("new button 2 color is: "+button2.getCssValue("background-color"));

        driver.switchTo().defaultContent();

        driver.close();
    }
}
