import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/target-practice");

        System.out.println("title of the page is: " + driver.getTitle());

        WebElement thirdHeader = driver.findElement(By.xpath("//*[@id='third-header']"));
        String thirdHeaderText = thirdHeader.getText();
        System.out.println("third header text is: "+thirdHeaderText);

        WebElement fifthHeader = driver.findElement(By.xpath("//*[contains(@class, 'green header')]"));
        String color = fifthHeader.getCssValue("color");
        System.out.println("color CSS property value of fifth header is : "+color);

        WebElement violetButton = driver.findElement(By.xpath("//*[contains(text(), 'Violet')]"));
        String violetButtonClassAttributeValues = violetButton.getAttribute("class");
        System.out.println("class attribute values of Violet button: "+violetButtonClassAttributeValues);

        WebElement greyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        String greyButtonText = greyButton.getText();
        System.out.println("grey button text is: " + greyButtonText);

        driver.close();
    }

}
