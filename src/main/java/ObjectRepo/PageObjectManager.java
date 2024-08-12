package ObjectRepo;



import org.openqa.selenium.WebDriver;


public class PageObjectManager
{
	
	WebDriver driver;

	
	public  PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public LoginPage getLogin() {
		return new  LoginPage(driver);
	}
	
	public HomePage getHome() {
		return new HomePage(driver);
	}
	
	public OrganizationsPage getOrganization() {
		return new OrganizationsPage(driver);
	}
	
	public ContactsPage getContacts() {
		return new ContactsPage(driver);
	}
	
	public CreateToDoPage getCreateToDo() {
		return new CreateToDoPage(driver);
	}
	
	public CreatingNewContactPage getCreateContact() {
		return new CreatingNewContactPage(driver)  ;
	}
	
	public CreatingNewOganizationPage getCreateOrg() {
		return new CreatingNewOganizationPage(driver);
	}
	
	public CreatingNewLeadPage getCreateLead() {
		return new CreatingNewLeadPage(driver);
	}
	
	public CreateContactInformationPage getContactInfo() {
		return new CreateContactInformationPage();
	}
	
	public LeadInformationPage getLeadInfo() {
		return new LeadInformationPage(driver);
	}
	
	public EventInformationPage getEventInfo() {
		return new EventInformationPage(driver);
	}
	
	public DuplicatingPage getDuplicatePage() {
		return new DuplicatingPage(driver);
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	
	
//	HomePage home;
//	OrganizationsPage organization;
//	ContactsPage contacts;
//	CreateToDoPage createToDo;
//	CreatingNewContactPage createContact;
//    CreatingNewOganizationPage createOrg;
//	CreatingNewLeadPage createLead;
//	ContactInformationPage contactInfo;
//	LeadInformationPage leadInfo;
//	EventInformationPage eventInfo;
//	DuplicatingPage duplicatePage;
	
	
	
	
	
	
	
	

}
