package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class AttributesTest extends BaseClass{
	
	@Test( /*priority = 3, description = "smoke scenario" dependsOnMethods = "moveToCalenderPage"*/ groups = "smoke")
	public void moveToLeadspage() {
		hp.clickLeadsLink();
		System.out.println("Leads page pass-smoke1");
		//for depends on group
	}

	@Test( /*priority = 4  description = "Adhoc scenario", dependsOnGroups = "smoke"*/ groups = "integration")
	public void moveToCalenderPage() {
		hp.clickCalenderLink();
		System.out.println("Cal page passintegration1");
		
		
	}

	@Test( /*priority = 2,  description = "Integration Scenario" dependsOnMethods = "moveToLeadspage" invocationTimeOut = 5000,*/ groups = "integration")
	public void moveToOrganizatopnPage() throws InterruptedException {
		Thread.sleep(7000); // for showing invocation timeout
		hp.clickOrganizationLink();
		System.out.println("Organization page pass-integration2");
		
		
	}

	@Test( /*priority = 1,  description = "Usability scenario" enabled = false dependsOnMethods ="moveToLeadspage" */ groups = "smoke")
	public void moveToContacts() {
		hp.clickContactsLink();
		System.out.println("Contacts page pass-smoke2");
		
		
	}

}
