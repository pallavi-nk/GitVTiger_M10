package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;
/**
 * This class contains elements with locators and respective business libraries of Creating new organization
 *@author sncsr
 */
public class CreatingNewOganizationPage {
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(name="accountname")
	private WebElement organizationNameTF;
	
	@FindBy(xpath="//input[contains(@title,'Save')]")
	private WebElement saveBTN;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	//initilization;
	public CreatingNewOganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	/**
	 * This method fetches the page header
	 * @return name
	 */
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	/**
	 * This method sets the organization name into the organization name text field
	 * @param name
	 */
	public void setOrganizationName(String name) {
		organizationNameTF.sendKeys(name);
		
	}
	/**
	 * This method click on saves button
	 */
     public void clickSaveBTN() {
    	 saveBTN.click();
     }
     /**
      * This method is used to select an industry from industry drop down
      * @param driverUtil
      * @param value
      */
     public void selectFromIndustryDD(WebDriverUtility driverUtil, String value) {
    	 driverUtil.handleDropdown(industryDD, value);
     }
     /**
      * This method is used to select an industry from type drop down
      * @param driverUtil
      * @param value
      */
     public void selectFromTypeDD(WebDriverUtility driverUtil, String value) {
    	 driverUtil.handleDropdown(typeDD, value);
     }
}
