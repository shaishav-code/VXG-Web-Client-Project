package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.UtilityClass;

public class LoginPage extends UtilityClass {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	
	@FindBy(id = "email")
	WebElement userEmailField;
	
	@FindBy(id = "password")
	WebElement userPasswordField;
	
	@FindBy(xpath = "//button[@class='bg-accentMain text-white p-2 rounded-lg uppercase hover:opacity-95 disabled:opacity-70']")
	WebElement signinButton;
	
	public void enterEmail(String email)
	{
		waitForTheElementToTheVisible(userEmailField);
		userEmailField.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		waitForTheElementToTheVisible(userPasswordField);
		userPasswordField.sendKeys(password);
	}
	
	public void clickSignInButton()
	{
		waitForTheElementToTheVisible(signinButton);
		signinButton.click();
	}
}
