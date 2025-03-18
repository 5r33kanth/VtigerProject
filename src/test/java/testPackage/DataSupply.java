package testPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSupply {
	
	@DataProvider(name = "userCredentials")
	public Object[][] userData(){
		
		return new Object[][] {
			
			{"resbin@gmail.com","resbin@123"},
			{"siva@gmail.com","siva@123"},
			{"sreekanth@gmail.com","sreekanth@123"},
			{"athulya@gmail.com","athulya@123"}
		};
	}
	
	@DataProvider(name = "userCredentials1")
	public Object[][] userData1(){
		
		return new Object[][] {
			
			{"sneha@gmail.com","sneha@123"},
			{"helen@gmail.com","helen@123"},
			{"pious@gmail.com","pious@123"},
			{"hari@gmail.com","hari@123"}
		};
	}
	
	@Test(dataProvider = "userCredentials1")
	public void printData(String username, String password) {
		
		System.out.println(username);
		System.out.println(password);
	}

}
