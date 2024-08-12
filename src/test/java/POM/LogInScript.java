package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInScript {
	@FindBy(id="loginClick")
	private WebElement button;
	
	@FindBy(id = "email")
	private WebElement emailTF;
	
	@FindBy(name="password")
	private WebElement setPasswordTF;
	
	@FindBy(name="keepLoggedInCheckBox")
	private WebElement checkbox;
	
	@FindBy(id="toPasswordRecoveryPageLink")
	private WebElement forgotPWDLink;
	
	@FindBy(name="login")
	private WebElement logIn;
	
	//Initialization
	public LogInScript(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public void logInButton() {
		button.click();
	}
	public void setEmailTF(String email) {
		emailTF.sendKeys(email);
	}
	public void setPasswordTF(String pwd) {
		setPasswordTF.sendKeys(pwd);
	}
	public void clickKeepMeLoggedIn() {
		checkbox.click();
	}
	public void clickForgotPWDLink() {
		forgotPWDLink.click();
	}
	public void logIn() {
		logIn.click();
	}
	

}
