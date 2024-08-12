package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventInformationPage {
	/**
	 * this class contains WebElements,locators and event information page
	 */
	//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//input[@name='Delete']")
	private WebElement deleteBTN;
	
	//Initilization
	public EventInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method returns page header
	 * @return  String
	 */
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	/**
	 * this method clicks on delete button
	 */
	public void clickDeleteBTN() {
		deleteBTN.click();
	}
	

}
