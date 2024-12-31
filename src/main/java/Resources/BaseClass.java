package Resources;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import PageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	public WebDriver driver;
	
	
	public LoginPage loginpage;
	
	// Invoke the Browser
	@BeforeMethod
	public WebDriver invokeBrowser() throws Exception
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(file);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		String HeadlessMode = System.getProperty("headless")!=null ? System.getProperty("headless") :prop.getProperty("headless");
				
		if(browserName.contains("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(HeadlessMode.contains("true"))
			{
			option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
			
		}
		else if(browserName.contains("firefox"))
		{
			FirefoxOptions option = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			if(HeadlessMode.contains("true"))
			{
			option.addArguments("headless");
			}
			
			driver = new FirefoxDriver(option);
			
		}
		else if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions option = new EdgeOptions();
			if(HeadlessMode.contains("true"))
			{
			option.addArguments("headless");
			}
			driver = new EdgeDriver(option);
		}
		
		driver.manage().window().maximize();
		driver.get("http://cloudtwo.cloud-vms.com/customer/alerts");
		return driver;
	}
	
	
	//Creating Class Objects
	@BeforeClass
	public void createObjects()
	{
		loginpage = new LoginPage(driver);
	}
	
	
	// Terminate the Browser
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
