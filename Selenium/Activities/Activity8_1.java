import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/tables");

        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped table')]/tbody/tr"));
        List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class, 'striped table')]/tbody/tr[1]/td"));

        System.out.println("Number of rows: "+rows.size());
        System.out.println("Number of columns: "+columns.size());

        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped table')]/tbody/tr[3]/td"));

        System.out.println("Data in third row is: ");
        for(WebElement thirdRowCell : thirdRow) {
            System.out.println(thirdRowCell.getText());
        }

        WebElement secondRowSecondCell = driver.findElement(By.xpath("//table[contains(@class, 'striped table')]/tbody/tr[2]/td[2]"));

        System.out.println("Data in second row and second cell is: "+secondRowSecondCell.getText());

        driver.close();
    }
}
