package basicCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LaunchWebDriver {
    public static void main(String[] args) {

        // Command to launch webdriver
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Common waits and pre-requisites
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // to type address and launch
        driver.get("https://www.github.com");

        //to get Title
        String title = driver.getTitle();
        if(title.toLowerCase().contains("github")){
            System.out.println("Title matched");
        }
        else{
            System.out.println("title mismatched");
        }

        //quit
        driver.quit();
    }
}
