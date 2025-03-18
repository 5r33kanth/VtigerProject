package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class DataSupply2Test extends BaseClass {
	
	@Test(dataProvider ="ContactDetails",dataProviderClass = DataSupply1.class )
	public void createContact(String salutation, String firstName, String lastName, String leadSrc, String title, String department, String email, String mobNo) {
		
		hp.clickContactsLink();
		cp.clickCreateContactIcon();
		cp.selectSalutation(salutation);
		cp.enterFirstName(firstName);
		cp.enterLastName(lastName);
		cp.selectLeadSrc(leadSrc);
		cp.enterTitle(title);
		cp.enterDepartmentTextField(department);
		cp.enterEmailTextField(email);
		cp.enterMobileTextField(mobNo);
		cp.save();
		
	}
	

}
