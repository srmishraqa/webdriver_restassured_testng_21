package basicCommands;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DBConnection {

    public static void main(String[] args) throws ClassNotFoundException {
        WebDriver driver = new ChromeDriver();
        Class.forName("oracle.jdbc.driver.OracleDriver");

        try {
            Connection con = DriverManager.getConnection("sample string");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("sample SQL Query");
            resultSet.getArray(0);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Select select = new Select(driver.findElement(By.xpath("")));
        List<WebElement> options = select.getOptions();
        for (WebElement element : options) {
            element.getText();
        }
    }
}
