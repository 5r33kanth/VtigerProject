package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class ContactTest extends BaseClass {
	
	@Test(/* invocationCount = 3 */)
	public void createContact() {
		
		hp.clickContactsLink();
		cp.clickCreateContactIcon();
		cp.selectSalutation("Mr.");
		cp.enterFirstName("Sree");
		cp.enterLastName("kanth");
		cp.selectLeadSrc("Partner");
		cp.enterTitle("Software Tester");
		cp.enterDepartmentTextField("Automation");
		cp.enterEmailTextField("sree@gmail.com");
		cp.enterMobileTextField("7907999888");
		cp.save();
		
		
	}
	

}
