package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class Verification2Test extends BaseClass{
	
	@Test( /*priority = 3, description = "smoke scenario" dependsOnMethods = "moveToCalenderPage"*/ groups = "Adhoc")
	public void moveToLeadspage() {
		hp.clickLeadsLink();
		System.out.println("Leads page pass-Adhoc1");
	//for depends on group
	}

	@Test( /*priority = 4  description = "Adhoc scenario"*/ groups = "Adhoc")
	public void moveToCalenderPage() {
		hp.clickCalenderLink();
		System.out.println("Cal page pass-Adhoc2");
		
		
	}

	

}
