import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/tables");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));

        System.out.println("Number of rows: " + rows.size());
        System.out.println("Number of columns: " + columns.size());

        WebElement secondRowSecondCell = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Data is second row and second cell is: "+secondRowSecondCell.getText());

        WebElement nameHeader = driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]"));
        nameHeader.click();

        secondRowSecondCell = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Data is second row and second cell is: "+secondRowSecondCell.getText());

        List<WebElement> footerRow = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        System.out.println("Data in footer row is: ");
        for(WebElement footerCell : footerRow) {
            System.out.println(footerCell.getText());
        }

        driver.close();
    }
}
