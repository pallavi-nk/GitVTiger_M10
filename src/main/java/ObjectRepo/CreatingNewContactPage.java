package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreatingNewContactPage {
	//Declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement pageHeader;
		
		@FindBy(name="lastname")
		private WebElement contactLastNameTF;
		
		@FindBy(xpath="//input[contains(@title,'Save')]")
		private WebElement saveBTN;
		
		@FindBy(xpath="//input[contains(@onclick,'Acounts')]")
		private WebElement organizationPlusBTN;
		
		private String organizationPath ="//a[text()='%s']";
		
		
		//initilization;
		public CreatingNewContactPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//Utilization
		/**
		 * This method fetches the page header
		 * @return String
		 */
		
		public String getPageHeader() {
			return pageHeader.getText();
		}
		/**
		 * This method sets the organization name into the organization name text field
		 * @param name
		 */
		public void setContactLastsName(String name) {
			contactLastNameTF.sendKeys(name);
			
		}
		/**
		 * This method click on saves button
		 */
	     public void clickSaveBTN() {
	    	 saveBTN.click();
	     }
	     /**
	      * This method selects the existing organization from the organizations window
	      * @param driverUtil
	      * @param orgName
	      */
	     public void selectExistingOrganization(WebDriverUtility driverUtil, String orgName) {
	    	 organizationPlusBTN.click();
	    	 driverUtil.switchToWindow("Accounts");
	    	 driverUtil.convertDynamicXpathToWebElement(organizationPath, orgName).click();
	    	 driverUtil.switchToWindow("Contacts");
	     }


}
