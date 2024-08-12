package genericUtilityScripts;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepo.ContactsPage;
import ObjectRepo.CreateContactInformationPage.ContactInformationPage;
import ObjectRepo.CreatingNewContactPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import genericUtility.IConstantPath;

public class CreatContactWithExistingContact1 {
	WebDriver driver;

	public static void main(String[] args) {
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		ContactsPage contact = new ContactsPage(driver);
		CreatingNewContactPage createContact = new CreatingNewContactPage(driver);
		ContactInformationPage contactInfo = new ContactInformationPage(driver);

		if (driver.getTitle().contains("vtiger CRM"))
			System.out.println("Login Page Displayed");
		else
			driverUtil.quitAllWindows();

		driver.findElement(By.name("user_name")).sendKeys(propertyUtil.readFromProperties("username"));
		driver.findElement(By.name("user_password")).sendKeys(propertyUtil.readFromProperties("password"));
		driver.findElement(By.id("submitButton")).submit();
		login.loginToVtiger(Properties.readFromProperties("username"), propertyUtil.readFromProperties("password"));

		if (driver.getTitle().contains("Home"))
			System.out.println("Home Page is Displayed");
		else
			driverUtil.quitAllWindows();
		driver.findElement(By.xpath("//a[contains(@href,'Contacts&action=index')]")).click();

		home.clickRequiredTab(driverUtil, TabNames.CONTACTS);
		if (driver.getTitle().contains("Contacts"))
			System.out.println("Contacts Page Displayed");
		else
			driverUtil.quitAllWindows();

		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		contact.clickCreateContactBTN();

		WebElement pageHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if (pageHeader.isDisplayed())
			if (createContact.getPageHeader().equalsIgnoreCase("Creating new contact"))
				System.out.println("Creating New Contact Page is Displayed");
			else
				driverUtil.quitAllWindows();

		Map<String, String> map = excel.readFromExcel("ContactsTestData", "Create Contact With Organization");

		driver.findElement(By.name("lastname")).sendKeys(map.get("Last Name"));
		driver.findElement(By.xpath("//img[contains(@onclick,'Accounts')]")).click();

		driverUtil.switchToWindow("Accounts");
		createContact.setContactLastName(map.get("Last Name"));
		createContact.selectExistingOrganization(driverUtil, map.get("Organization Name"));

		driver.findElement(By.xpath("//a[text()='" + map.get("Organization Name") + "']")).click();

		driverUtil.switchToWindow("Contacts");

		driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
		createContact.clickSaveBTN();

		String newContactPageHeader = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if (newContactPageHeader.contains(map.get("Last Name")))
			if (contactInfo.getPageHeader().contains(map.get("Last Name")))
				System.out.println("Contact created successfully");
			else
				driverUtil.quitAllWindows();

		driver.findElement(By.xpath("//input[@name='Delete']")).click();
		contactInfo.clickDeleteBTN();
		driverUtil.handleAlert("ok");

		if (driver.getTitle().contains("Contacts")) {

		}

		excel.saveExcel(IConstantPath.EXCEL_PATH);
		WebElement adminWidget = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		driverUtil.mouseHover(adminWidget);

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		home.signOutOfVtiger(driverUtil);
		excel.closeExcel();
		driverUtil.quitAllWindows();

	}

}
