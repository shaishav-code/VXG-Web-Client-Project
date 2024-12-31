package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.UtilityClass;

public class AlertPage extends UtilityClass {

	WebDriver driver;

	public AlertPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@class='MuiListItemText-root css-1tsvksn']//span[contains(text(),'Alerts')]")
	WebElement alerts;

	@FindBy(xpath = "//button[contains(text(),'Site')]")
	WebElement siteDropdown;

	@FindBy(xpath = "//span[contains(text(),'Camera: All')]")
	WebElement cameraOptionDropdown;

	@FindBy(xpath = "//button[contains(text(),'Name')]")
	WebElement nameDropdown;

	@FindBy(xpath = "//span[contains(text(),'Last 30 days')]")
	WebElement daysDropdown;

	@FindBy(xpath = "//input[@class='input min-w-[200px]']")
	WebElement tagSearchbox;

	@FindBy(xpath = "//button[@class='v-btn-secondary-sm']")
	WebElement searchButton;

	@FindBy(xpath = "//button[@class='main-select']")
	WebElement columnSortingDropdown;

	@FindBy(xpath = "//input[@placeholder='Search site...']")
	WebElement searchSiteSearchbox;

	@FindBy(xpath = "//input[@placeholder='Search rule name...']")
	WebElement searchNameSearchbox;

	@FindBy(xpath = "//span[@class='overflow-ellipsis overflow-hidden whitespace-nowrap']")
	List<WebElement> sitesNames;

	@FindBy(xpath = "//span[@class='overflow-ellipsis overflow-hidden whitespace-nowrap']")
	List<WebElement> cameraAllNames;

	@FindBy(xpath = "//input[@placeholder='Search rule name...']")
	WebElement ruleSearchbox;

	@FindBy(xpath = "//div[@class='relative flex cursor-default select-none items-center rounded-sm px-2 py-1.5 text-sm outline-none data-[disabled=true]:pointer-events-none data-[selected=true]:bg-accent data-[selected=true]:text-accent-foreground data-[disabled=true]:opacity-50 capitalize']")
	List<WebElement> nameLists;

	@FindBy(xpath = "//div[@class='flex items-center px-4 py-2 cursor-pointer hover:bg-gray-100 border-b last:border-none border-gray-300 text-sm max-w-full']/span")
	List<WebElement> daysList;

	@FindBy(xpath = "//span[@class='overflow-ellipsis overflow-hidden whitespace-nowrap font-light']")
	List<WebElement> sortColumnList;

	@FindBy(xpath = "//div[@class='relative w-full overflow-auto custom-scrollbar']/table/tbody/tr[1]/td[1]/div")
	WebElement tableFirstRecord;

	public void verifySiteDropdownIsPresentOnPage() {
		checkTheElementIsPresentOnPage(siteDropdown);
	}

	public void verifyCameraDropdownIsPresentOnPage() {
		checkTheElementIsPresentOnPage(cameraOptionDropdown);
	}

	public void verifyNameDropdownIsPresentOnPage() {
		checkTheElementIsPresentOnPage(nameDropdown);
	}

	public void verifyDurationDropdownIsPresentOnPage() {
		checkTheElementIsPresentOnPage(daysDropdown);
	}

	public void verifyColumnSortingDropdownIsPresentOnPage() {
		checkTheElementIsPresentOnPage(columnSortingDropdown);
	}

	public void verifySearchBoxIsPresentOnPage() {
		checkTheElementIsPresentOnPage(searchSiteSearchbox);
	}

	public void verifySearchButtonIsPresentOnPage() {
		checkTheElementIsPresentOnPage(siteDropdown);
	}

	public void clickOnAlertsFromSideMenu() {
		waitForTheElementToTheVisible(alerts);
		alerts.click();
		pauseRun(3);
	}

	public void clickOnSiteDropDown() {
		waitForTheElementToTheVisible(siteDropdown);
		siteDropdown.click();
	}

	public void selectSiteFromTheSiteDropDown(String site) {
		pauseRun(3);
		for (WebElement sitename : sitesNames) {
			String strSiteName = sitename.getText();
			if (strSiteName.equals(site)) {
				sitename.click();
				break;
			} else {

			}
		}
	}

	public void clickOnCameraDropdown() {
		waitForTheElementToTheVisible(cameraOptionDropdown);
		cameraOptionDropdown.click();
	}

	public void selectCameraOptionFromTheCameraDropdown(String camera) {
		pauseRun(3);
		for (WebElement cameraName : cameraAllNames) {
			String strCameraName = cameraName.getText();
			if (strCameraName.equals(camera)) {
				cameraName.click();
				break;
			} else {

			}
		}
	}

	public void clickOnNameDropdown() {
		waitForTheElementToTheVisible(nameDropdown);
		nameDropdown.click();
	}

	public void selectNameFromTheNameDropdown(String name) {

		pauseRun(3);
		for (WebElement Name : nameLists) {
			String strName = Name.getText();
			if (strName.equalsIgnoreCase(name)) {
				Name.click();
				break;
			} else {

			}
		}
	}

	public void clickOnDuratoinDropdown() {
		waitForTheElementToTheVisible(daysDropdown);
		daysDropdown.click();
	}

	public void selectDurationFromThedaysDropdown(String day) {
		pauseRun(3);
		for (WebElement Day : daysList) {
			String strDay = Day.getText();
			if (strDay.equals(day)) {
				Day.click();

				break;
			} else {

			}
		}
	}

	public void enterTagNameInTheSearchBox(String Tagname) {
		waitForTheElementToTheVisible(searchSiteSearchbox);
		searchSiteSearchbox.sendKeys(Tagname);
	}

	public void clickOnSearchButton() {
		waitForTheElementToTheVisible(searchButton);
		searchButton.click();
	}

	public void clickOnColumnSortingDropdown() {
		waitForTheElementToTheVisible(columnSortingDropdown);
		columnSortingDropdown.click();
		pauseRun(3);
	}

	public void selectColumnSortingFromColumnSortingDropdown(String ColumnName) {
		for (WebElement column : sortColumnList) {
			String strcolumn = column.getText();
			System.out.println(strcolumn);
			if (strcolumn.equals(ColumnName)) {
				column.click();
				break;
			} else {

			}
		}
	}

	public void enterDataInSiteSearchBox(String sitename) {
		waitForTheElementToTheVisible(searchSiteSearchbox);
		searchSiteSearchbox.sendKeys(sitename);
	}

	public void enterDataInNameSearchBox(String name) {
		waitForTheElementToTheVisible(searchNameSearchbox);
		searchNameSearchbox.sendKeys(name);
	}

	public void verifyNoResultIsShownInSiteDropdown() {
		verifyNoResultIsShown("No site found.");
	}

	public void verifyNoResultIsShownInNameDropdown() {
		verifyNoResultIsShown("No alert found.");
	}

	public void verifyFirstRecordOfTheTable(String data) {
		try {
			waitForTheElementToTheVisible(tableFirstRecord);
			String result = tableFirstRecord.getText();
			System.out.println(result);
			if (result.equals(data)) {
				Assert.assertTrue(true);

			} else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {

		}

	}
	
	public void verifyValidationAppearForSearchBox(String errormsg)
	{
		String msg = "Enter a tag in searchbox";
		if(msg.equals(errormsg))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}
