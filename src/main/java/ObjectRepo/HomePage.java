package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.TabName;
import genericUtility.WebDriverUtility;
/**
 * this class contains elements,locators and respective business libraries.
 */
public class HomePage {
	//declarartion
	private String CommonPathForTabs ="//a[contains(@href,'index.php?module=%s&action=index')]";
	
//	@FindBy(xpath="//a[contains(@href,'index.php?module=Accounts&action=index')]")
//	private WebElement oganizationsTab;
//	
//	@FindBy(xpath="//a[contains(@href,'index.php?module=Contacts&action=index')]")
//	private WebElement contactsTab;
//	
//	@FindBy(xpath="(//a[text()='Leads'])[1]")
//	private WebElement leadsTab;
	
	@FindBy(id="qccombo")
	private WebElement quickCreateDD;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminWidget;
	
	//Initilization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization
//	public void clickOrganizationTab() {
//		oganizationsTab.click();
//	}
//	public void clickContactsTab() {
//		contactsTab.click();
//	}
//	public void clickLeadsTab() {
//		leadsTab.click();
//	}
	
	
	
	

	public void SignOutOfVTiger(WebDriverUtility driverutility) {
		driverutility.mouseHover(adminWidget);
		
}
	/**
	 * This method clicks on specified tab
	 * @param driverUtil
	 * @param tabName
	 */
	public void clickRequiredTab(WebDriverUtility driverUtil, TabName tabname) {
		driverUtil.convertDynamicXpathToWebElement(CommonPathForTabs, tabname.getTabName()).click();
	}
	/**
	 * this method is used to select an option from quick create drop dowbn
	 * @param driverUtil
	 * @param value 
	 */
	public void selectFromQuickCreateDD(WebDriverUtility driverUtil,String value) {
		driverUtil.handleDropdown(quickCreateDD,value);
		
	}
	
}
