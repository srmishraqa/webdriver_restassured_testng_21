package basicCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class LaunchWebDriver {
    public static void main(String[] args) throws AWTException, InterruptedException {

        // Command to launch webdriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Common waits and pre-requisites
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        // to type address and launch
        driver.get("https://www.google.com");

        //to get Title
        String title = driver.getTitle();
        if (title.toLowerCase().contains("google")) {
            System.out.println("Title matched");
        } else {
            System.out.println("title mismatched");
        }

        //to type in capitals
        driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.SHIFT, "selenium"));
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        //Robot robot = new Robot();
        //robot.keyPress(KeyEvent.VK_ENTER);


        Thread.sleep(5000);
        //quit
        driver.quit();
    }
}
