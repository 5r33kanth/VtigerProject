package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class LeadsTest extends BaseClass{
	
	@Test
	public void createLead() {
		
		hp.clickLeadsLink();
		ld.clickCreateLeadIcon();
		ld.selectSalutation("Mr.");
		ld.enterFirstName("Hari");
		ld.enterLastName("Potter");
		ld.enterCOmpany("Hogwarts");
		ld.enterDesignationTitle("Tester");
		ld.selectLeadSrc("Conference");
		ld.industry("Education");
		ld.enterMobileTextField("8955621478");
		ld.enterEmailTextField("hari@hogwarts.com");
		ld.leadStatus("Cold");
		ld.save();
		
		
	}

}
