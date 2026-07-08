package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import driver.DriverFactory;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageObjects.AdminPage;
import pageObjects.LoginPage;

public class BaseTest {
	public static Properties properties = null;
	public static WebDriver driver = null;
	
	public String username;
	public String password;

	protected LoginPage loginPage;
	protected AdminPage adminPage;
	
	public static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
	
	public Properties loadProperties() throws IOException {
		FileInputStream propertiesPath = new FileInputStream("./src/test/resources/config.properties");
		
		properties = new Properties();
		properties.load(propertiesPath);
		
		return properties;		
	}
	
	@BeforeSuite
	public void launchBrowser() throws IOException {
		
		LOGGER.info("Properties Loaded");
		loadProperties();
		
		String browser = properties.getProperty("browser");
		WebDriver driver = DriverFactory.createDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DriverManager.setDriver(driver);
		
		String url = properties.getProperty("URl");
		DriverManager.getDriver().get(url);
		
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		
	}

	@BeforeTest
	public void initializePages(){
		loginPage = new LoginPage();
		adminPage = new AdminPage();
	}
	
	@AfterSuite
	public void tearDown() {

		DriverManager.quitDriver();
	}

}
