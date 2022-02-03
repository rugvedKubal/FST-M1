import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/selects");

        WebElement dropDownElement = driver.findElement(By.id("single-select"));
        WebElement message = driver.findElement(By.id("single-value"));

        Select dropDown = new Select(dropDownElement);
        dropDown.selectByVisibleText("Option 2");
        System.out.println(message.getText());
        dropDown.selectByIndex(3);
        System.out.println(message.getText());
        dropDown.selectByValue("4");
        System.out.println(message.getText());

        List<WebElement> options = dropDown.getOptions();
        System.out.println("All options are as follows: ");
        for(WebElement option : options) {
            System.out.println(option.getText());
        }

        driver.close();
    }
}
