package basicCommands;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        Thread.sleep(5000);
        takeScreenshot();

        driver.quit();

    }
    
    public static void takeScreenshot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".jpg"));
    }
}
