package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class contains elements,locators and respective libraries
 */

public class VTigerLoginPage {
	//Declaration
	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
    private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginBTN;
	/**
	 * 
	 * @param driver
	 */
	//Initilization
	public  VTigerLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	/**
	 * this method is used to log in to vtiger application
	 * @param username
	 * @param password
	 */
	
	//Utilization
	public void logInToVtiger(String username,String password) {
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginBTN.submit();
		
	}
	
	
	
}
