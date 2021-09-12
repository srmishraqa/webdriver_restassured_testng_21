package basicCommands;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class SeleniumStructureAndFluentWait {
    public static void main(String[] args) throws InterruptedException {
        // SearchContext - is the top most Interface
        // WebDriver - extends to search context
        // RemoteWebDriver - implements to WebDriver,JSExecutor,FindBys
        // ChromeDriver extends to RemoteWebDriver

        // findElement and findElements() both comes from RemoteWebDriver Class
        // WebElement interface extends to SearchContext and TakeScreenshot
        // RemoteWebElement implements WebElement

        /*
         * Fluent Wait Syntax
         */
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.name("q"));
            }
        });

        element.sendKeys(Keys.chord("Test", Keys.ENTER));

        Thread.sleep(5000);
        driver.quit();
    }
}
