package genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.PageObjectManager;

public class BaseClass {

	// @BeforeSuite
	// @BeforeTest
	protected PropertiesUtility propertyUtil;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility driverUtil;

	protected WebDriver driver;
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	protected PageObjectManager pageObjectManager;
	protected LoginPage logIn;
	protected HomePage home;
	protected SoftAssert soft;

	@BeforeClass
	public void classConfiguration() {
		propertyUtil = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		driverUtil = new WebDriverUtility();

		propertyUtil.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);

		driver = driverUtil.launchBrowser(propertyUtil.readFromProperties("browser"));
		driverUtil.maximizeBrowser();
		long time = (Long) jutil.convertStringToAnyDataType(propertyUtil.readFromProperties("timeouts"), DataType.LONG);
		driverUtil.waitTillElementFound(time);
		sdriver = driver;
		sjutil = jutil;
	}

	@BeforeMethod
	public void methodConfiguration() {
		driverUtil.navigateToApp(propertyUtil.readFromProperties("url"));
		Assert.assertTrue(driver.getTitle().contains("vtiger CRM"));
		
		pageObjectManager = new PageObjectManager(driver);
		logIn = pageObjectManager.getLogin();
		home = pageObjectManager.getHome();

		logIn.loginToVtiger(propertyUtil.readFromProperties("username"), propertyUtil.readFromProperties("password"));
		Assert.assertTrue(driver.getTitle().contains("Home"));
		soft = new SoftAssert();
	}	

	@AfterMethod
	public void methodTeardown() {
		excel.saveExcel(IConstantPath.EXCEL_PATH);
		home.SignOutOfVTiger(driverUtil);
	}

	@AfterClass
	public void classTeardown() {
		excel.closeExcel();
		driverUtil.quitAllWindows();
	}
	// @AfterTest
	// @AfterSuite

}
