import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net");

        System.out.println("title of the page is: "+driver.getTitle());

        WebElement aboutUsElement_using_id = driver.findElement(By.id("about-link"));
        System.out.println("Text inside the element: "+aboutUsElement_using_id.getText());

        WebElement aboutUsElement_using_className = driver.findElement(By.className("green"));
        System.out.println("Text inside the element: "+aboutUsElement_using_className.getText());

        WebElement aboutUsElement_using_linkText = driver.findElement(By.linkText("About Us"));
        System.out.println("Text inside the element: "+aboutUsElement_using_linkText.getText());

        WebElement aboutUsElement_using_cssSelector = driver.findElement(By.cssSelector("a#about-link"));
        System.out.println("Text inside the element: "+aboutUsElement_using_cssSelector.getText());

        driver.close();
    }

}
