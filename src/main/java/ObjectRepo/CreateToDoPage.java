package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.DataType;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
/**
 * this class contains elements,locators and respective business libraries ofcreate to do page
 * @author sncsr
 */
public class CreateToDoPage {
	//Declaration
	@FindBy(name="subject")
	private WebElement subjectTF;
	 
	@FindBy(id="jscal_trigger_date_start")
	private WebElement startDateWidget;
	
	@FindBy(xpath="//div[@class='calandar' and contains(@style,'block')]/descendant::td[@class='tetle']")
	private WebElement calendarTitle;
	
	private String calendarCommonPath ="//div[@class='calendar' and contains(@style, 'block')]/descendant::td[text()='>>'";
	
	@FindBy(id="lscal_trigger_due_date")
	private WebElement dueDateWidget;
	
	@FindBy(xpath="//input[@value=' save']")
	private WebElement saveBTN;
	
	//Initilization
	public CreateToDoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public void setSubject(String subject) {
		subjectTF.sendKeys(subject);
	}
	public void clickStartDateWidget() {
		startDateWidget.click();
		
	}
	public void clickDueDatewidget() {
		dueDateWidget.click();
	}
	public void datePicker(JavaUtility jutil, WebDriverUtility driverUtil, String reqDate) {
		String[] startDate =jutil.splitString(reqDate, "-");
		int reqStartYear =(Integer)jutil.convertStringToAnyDataType(startDate[0], DataType.INT);
		String reqStartDate =startDate[2];
		int reqStartMonth =jutil.convertMonthToInt(startDate[1]);
		
		String CurrentMonthYear =calendarTitle.getText();
		String[] str=jutil.splitString(CurrentMonthYear, ",");
		int currentYear =(Integer)jutil.convertStringToAnyDataType(str[1],DataType.INT);
		
		while(currentYear<reqStartYear) {
			driverUtil.convertDynamicXpathToWebElement(calendarCommonPath, ">>").click();
			CurrentMonthYear = calendarTitle.getText();
			str =jutil.splitString(CurrentMonthYear,",");
			currentYear =(Integer)jutil.convertStringToAnyDataType(str[1], DataType.INT);
			
		}
		int currentMonth= jutil.convertMonthToInt(str[0]);
		while(currentMonth<reqStartMonth) {
			driverUtil.convertDynamicXpathToWebElement(calendarCommonPath, ">").click();
			CurrentMonthYear = calendarTitle.getText();
			str =jutil.splitString(CurrentMonthYear,",");
			currentMonth =jutil.convertMonthToInt(str[0]);
			
		}
		while(currentMonth>reqStartMonth) {
			driverUtil.convertDynamicXpathToWebElement(calendarCommonPath,"<").click();
			
		}
	}
	}
	
	
	
	
	


