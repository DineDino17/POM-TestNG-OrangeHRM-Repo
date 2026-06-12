package commonUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class utils {
	public static Properties properties = null;
	public static WebDriver driver = null;
	
	public String username;
	public String password;
	
	public static final Logger LOGGER = LogManager.getLogger(utils.class);
	
	public Properties loadProperties() throws IOException {
		FileInputStream propertiesPath = new FileInputStream("./src/test/resources/config/config.properties");
		
		properties = new Properties();
		properties.load(propertiesPath);
		
		return properties;		
	}
	
	@BeforeSuite
	public void launchBrowser() throws IOException {
		
		LOGGER.info("Properties Loaded");
		loadProperties();
		
		String browser = properties.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			//From Selenium 4.6 Webdriver manager will automatically download and uses the driver as per the local browser
			//System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverLocation"));
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			//System.setProperty("webdriver.edge.driver", properties.getProperty("edgeDriverLocation"));
			driver = new EdgeDriver();
		}
		
		String url = properties.getProperty("URl");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
