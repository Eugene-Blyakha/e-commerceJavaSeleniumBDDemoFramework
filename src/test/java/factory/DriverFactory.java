package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser) {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("INVALID BROWSER" + browser);
        }

        driver.manage().window().maximize();
        DriverFactory.driver.set(driver);
        return driver;
    }

    public static WebDriver getDriver(){

        return driver.get();
    }

}
