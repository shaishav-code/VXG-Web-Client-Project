package PositiveTestCases;

import org.testng.annotations.Test;

import PageObjects.AlertPage;
import Resources.BaseClass;
import Utility.UtilityClass;

public class TC_AlertPage extends BaseClass {

	UtilityClass utility;
	AlertPage alertPage;

	//Successfully Login With Valid credentials and get the page title
	@Test(priority = 4)
	public void loginWithValidEmailAndPassword()
	{
		utility = new UtilityClass(driver);
		utility.Login("dev@testing.com", "123456");
		
		System.out.println(driver.getTitle()); 
	}
	
	// Verify the Element is present on the page
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
	
	// Ensure that the Data is showing as per the selection of the column from the column dropdown
	@Test(priority = 2)
	public void ensureDataIsShowingAsPerSelectionOfColumnFromColumnDropdown()
	{
		utility = new UtilityClass(driver);
		utility.Login("dev@testing.com", "123456");
		
		alertPage = new AlertPage(driver);
		alertPage.clickOnAlertsFromSideMenu();
		
		alertPage.clickOnColumnSortingDropdown();
		alertPage.selectColumnSortingFromColumnSortingDropdown("Type");
		
		alertPage.verifyFirstRecordOfTheTable("ChatGPT");
	}
	
	// Check the filter functionality wroking fine or not
	@Test(priority = 3)
	public void checkFilersAreWorkingProper()
	{
		utility = new UtilityClass(driver);
		utility.Login("dev@testing.com", "123456");
		
		alertPage = new AlertPage(driver);
		alertPage.clickOnAlertsFromSideMenu();

		alertPage.clickOnSiteDropDown();
		alertPage.selectSiteFromTheSiteDropDown("Office");
		
		alertPage.clickOnCameraDropdown();
		alertPage.selectCameraOptionFromTheCameraDropdown("Axis");
		
		alertPage.clickOnNameDropdown();
		alertPage.selectNameFromTheNameDropdown("alert");
		
		alertPage.clickOnDuratoinDropdown();
		alertPage.selectDurationFromThedaysDropdown("Last 30 days");
	}
}
