package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains elements with locators and respective business libraries of organization
 *@author sncsr
 */
public class OrganizationsPage {
	//declaration
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement createOrgBTN;


//initilization;
public OrganizationsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}
//Utilization
/**
 * This method clicks on the create organization button
 */
public void clickCreateOrgBTN() {
	createOrgBTN.click();
}
}
