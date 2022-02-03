import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/selects");

        WebElement multiSelectElement = driver.findElement(By.id("multi-select"));
        WebElement message = driver.findElement(By.id("multi-value"));

        Select multiSelectDropDown = new Select(multiSelectElement);

        if(multiSelectDropDown.isMultiple()) {
            multiSelectDropDown.selectByVisibleText("Javascript");
            System.out.println(message.getText());

            multiSelectDropDown.selectByValue("node");
            System.out.println(message.getText());

            for(int i = 4; i <= 6; i++) {
                multiSelectDropDown.selectByIndex(i);
            }
            System.out.println(message.getText());

            multiSelectDropDown.deselectByValue("node");
            System.out.println(message.getText());

            multiSelectDropDown.deselectByIndex(7);
            System.out.println(message.getText());

            List<WebElement> selectedOptions = multiSelectDropDown.getAllSelectedOptions();
            for(WebElement selectedOption : selectedOptions) {
                System.out.println("Selected Option is: "+selectedOption.getText());
            }

            multiSelectDropDown.deselectAll();
            System.out.println(message.getText());
        }

        driver.close();
    }
}
