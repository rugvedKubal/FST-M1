import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity11_4 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/tab-opener");
        System.out.println("Title of page is: "+driver.getTitle());
        System.out.println("window handle of main window is: "+driver.getWindowHandle());

        driver.findElement(By.id("launcher")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("All window handles are as follows: ");
        System.out.println(windowHandles);

        for(String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

        System.out.println("New tab window handle is: "+driver.getWindowHandle());

        wait.until(ExpectedConditions.titleIs("Newtab"));

        System.out.println("Title of new tab is: "+driver.getTitle());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.content")));
        String headingOfNewTab = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("Heading of new tab is: "+headingOfNewTab);

        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        windowHandles = driver.getWindowHandles();
        System.out.println("All window handles are as follows: ");
        System.out.println(windowHandles);

        for(String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

        System.out.println("New tab 2 window handle is: "+driver.getWindowHandle());

        wait.until(ExpectedConditions.titleIs("Newtab2"));

        System.out.println("Title of new tab 2 is: "+driver.getTitle());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.content")));
        String headingOfNewTab2 = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("Heading of new tab 2 is: "+headingOfNewTab2);

        driver.quit();
    }
}
