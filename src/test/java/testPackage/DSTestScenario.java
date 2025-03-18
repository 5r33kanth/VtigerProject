package testPackage;

import org.testng.annotations.Test;

public class DSTestScenario {
	
	@Test(dataProvider = "userCredentials1", dataProviderClass = DataSupply.class)
	public void printData(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}

}
