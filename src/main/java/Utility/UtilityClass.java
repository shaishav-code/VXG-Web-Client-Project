package Utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UtilityClass {

	
	 public WebDriver driver;
	public UtilityClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "email")
	WebElement userEmailField;
	
	@FindBy(id = "password")
	WebElement userPasswordField;
	
	@FindBy(xpath = "//button[@class='bg-accentMain text-white p-2 rounded-lg uppercase hover:opacity-95 disabled:opacity-70']")
	WebElement signinButton;
	
	@FindBy(xpath = "//div[@class='py-6 text-center text-sm']")
	WebElement noResultFoundFromDropdown;
	
	public void pauseRun(int sec)
	{
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForTheElementToTheVisible(WebElement ele)
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

			webDriverWait.until(ExpectedConditions.visibilityOf(ele));
		}
		catch(Exception e)
		{
			System.out.println("Element is not visible");
		}
	}
	
	
	public void Login(String email, String password)
	{
		waitForTheElementToTheVisible(userEmailField);
		userEmailField.sendKeys(email);
		waitForTheElementToTheVisible(userPasswordField);
		userPasswordField.sendKeys(password);
		waitForTheElementToTheVisible(signinButton);
		signinButton.click();
		
	}
	
	public void checkTheElementIsPresentOnPage(WebElement ele)
	{
		try 
		{
			if(ele.isDisplayed()==true)
			{
				Assert.assertTrue(true);
				System.out.println("Element is present on the page");
			}
			else
			{
				Assert.assertTrue(false);
				System.out.println("Element is not present on the page");
			}
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	
	public void verifyNoResultIsShown(String msg)
	{
		pauseRun(3);
		String Resultmsg = noResultFoundFromDropdown.getText();
		if(Resultmsg.equals(msg))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	
}
