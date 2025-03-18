package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class OrganizationTest extends BaseClass {
	
	@Test
	public void createOrganization() {
		
		hp.clickOrganizationLink();
		op.clickCreateOrganizaton();
		op.enterOrganizationName("TCS");
		op.enterEmployees("120");
		op.selectIndustry("Engineering");
		op.selectAccountType("Investor");
		op.enterPhoneTextField("7897888744");
		op.enterEmailTextField("tcs@gmail.com");
		op.save();
		
	}
	

}
