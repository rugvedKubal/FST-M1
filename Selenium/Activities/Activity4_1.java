import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement aboutUsLink = driver.findElement(By.xpath("//*[@id='about-link']"));

        aboutUsLink.click();

        System.out.println("title of the page after clicking 'About Us' link is: " + driver.getTitle());

        driver.close();
    }

}
