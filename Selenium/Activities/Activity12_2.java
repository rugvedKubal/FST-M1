import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Activity12_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.training-support.net/selenium/nested-iframes");

        System.out.println("title of the page is: " + driver.getTitle());

        driver.switchTo().frame(0);
        driver.switchTo().frame(0);

        String iFrame1Heading = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("iFrame 1 heading is: "+iFrame1Heading);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        driver.switchTo().frame(1);

        String iFrame2Heading = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("iFrame 2 heading is: "+iFrame2Heading);

        driver.close();
    }
}
