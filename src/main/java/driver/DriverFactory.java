package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser){
        switch(browser.toLowerCase()){
            case "chrome":
                //From Selenium 4.6 Webdriver manager will automatically download and uses the driver as per the local browser
                //System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverLocation"));
                return new ChromeDriver();
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }
}
