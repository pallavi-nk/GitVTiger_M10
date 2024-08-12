package testNGImplementation;

import java.util.Map;

import org.testng.annotations.Test;

import ObjectRepo.OrganizationInformationPage;
import ObjectRepo.OrganizationsPage;
import genericUtility.BaseClass;
import genericUtility.TabName;


	public class CreatingNewOrganizationPage extends BaseClass {

		@Test(groups = "organizations")
		public void createOrgWithTypeAndIndustryTest() {
			OrganizationsPage organization = pageObjectManager.getOrganization();
			CreatingNewOrganizationPage createOrg = pageObjectManager.getCreateOrg();
			OrganizationInformationPage orgInfo = pageObjectManager.getOrgInfo();

			home.clickRequiredTab(driverUtil, TabName.ORGANIZATIONS);

			soft.assertTrue(driver.getTitle().contains("Organizations"));

			organization.clickCreateOrgBTN();

			soft.assertTrue(createOrg.getPageHeader().equalsIgnoreCase("creating new organization"));

			Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "Create Organization With Industry And Type");
			createOrg.setOrganizationName(map.get("Organization Name"));
			createOrg.selectFromIndustryDD(driverUtil, map.get("Industry"));
			createOrg.selectFromTypeDD(driverUtil, map.get("Type"));
			createOrg.clickSaveBTN();

			soft.assertTrue(orgInfo.getPageHeader().contains(map.get("Organization Name")));
			
			orgInfo.clickDeleteBTN();
			driverUtil.handleAlert("ok");

			soft.assertTrue(driver.getTitle().contains("Organizations"));
			if (driver.getTitle().contains("Organizations")) 
				excel.writeToExcel("OrganizationsTestData", "Create Organization With Industry And Type", "Pass");
			else 
				excel.writeToExcel("OrganizationsTestData", "Create Organization With Industry And Type", "Fail");
			soft.assertAll();
		}

		private void clickSaveBTN() {
			// TODO Auto-generated method stub
			
		}

	}


