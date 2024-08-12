package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	//declaration
	@FindBy(css="span.dvHeaderText")
	private WebElement pageHeader;

  @FindBy(xpath="//input[@name='Delete']")
  private WebElement deleteBTN;
  
  
  //Initilization;
  public OrganizationInformationPage(WebDriver driver) {
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
	 * This method is used to click on delete button
	 * @param name
	 */
	public void clickDeleteBTN() {
		deleteBTN.click();
	

}
	}
