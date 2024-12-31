package NegativeTestCases;

import org.testng.annotations.Test;

import PageObjects.AlertPage;
import PageObjects.LoginPage;
import Resources.BaseClass;
import Utility.UtilityClass;

public class TC_AlertPage extends BaseClass{
	
	UtilityClass utility ;
	AlertPage alertPage;

	
	//Verify the Element is Present On The Page
	@Test(priority = 1)
	public void VerifyElementsIsPresentOnPage()
	{
		utility = new UtilityClass(driver);
		utility.Login("dev@testing.com", "123456");
		
		alertPage = new AlertPage(driver);
		alertPage.clickOnAlertsFromSideMenu();
		alertPage.verifySiteDropdownIsPresentOnPage();
		alertPage.verifyCameraDropdownIsPresentOnPage();
		alertPage.verifyNameDropdownIsPresentOnPage();
		alertPage.verifyDurationDropdownIsPresentOnPage();
		alertPage.verifySearchBoxIsPresentOnPage();
		alertPage.verifySearchButtonIsPresentOnPage();
		alertPage.verifyColumnSortingDropdownIsPresentOnPage();
	}
	
	//Attempt to Apply Invalid Inputs in the site filter drown down search button
	@Test(priority = 2)
	public void attemptToApplyInvalidInputInSiteFilter()
	{
		utility = new UtilityClass(driver);
		utility.Login("dev@testing.com", "123456");
		
		alertPage = new AlertPage(driver);
		alertPage.clickOnAlertsFromSideMenu();
		
		alertPage.clickOnSiteDropDown();
		alertPage.enterDataInSiteSearchBox("DemoDetails");
		
		alertPage.verifyNoResultIsShownInSiteDropdown();
		
	}

	//Attempt to Apply Invalid Inputs in the Name filter drowndown search button
	@Test(priority = 3)
	public void attemptToApplyInvalidInputInNameFilter()
	{
		utility = new UtilityClass(driver);
		utility.Login("dev@testing.com", "123456");
		
		alertPage = new AlertPage(driver);
		alertPage.clickOnAlertsFromSideMenu();
		
		alertPage.clickOnNameDropdown();
		alertPage.enterDataInNameSearchBox("DemoDetails");
		
		alertPage.verifyNoResultIsShownInNameDropdown();
		
	}
	
	// Verify validation message appears when submitting without input.
	@Test(priority = 4)
	public void erifyValidationMessageAppearsWhenSubmittingWithoutInput()
	{
		utility = new UtilityClass(driver);
		utility.Login("dev@testing.com", "123456");
		
		alertPage = new AlertPage(driver);
		alertPage.clickOnAlertsFromSideMenu();
		
		alertPage.clickOnSearchButton();
		alertPage.verifyValidationAppearForSearchBox("Searcbox is empty");
		
	}
}
