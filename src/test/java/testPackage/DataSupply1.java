package testPackage;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.DataUtilities;

public class DataSupply1 {
	
	@DataProvider(name = "ContactDetails")
	public Object[][] userData(){
		
		return new Object[][] {
			
			{"Mr.","BatMan", "K", "Employee","Health Inspector","health","batman@gmail.com","7878547898"},
			{"Ms.","Wonder","Women","Self Generated","Student","DC","wonder@gmail.com","8854698752"},
			{"Mr.","SuperMan","Raj","Partner","Journalist","EEE","superman@gmail.com","2224778965"},
	
		};
	}
	
	//using database
	@DataProvider(name="dataBaseContacts")
	public Object[][] databaseContacts(){
		DataUtilities du = new DataUtilities();
		
		ArrayList<Object[]> result = du.getDataFromDatabase("select * from contacts");
		return result.toArray(new Object[0][]);
	}
	
	@Test(dataProvider = "dataBaseContacts")
	public void contactDetails(String salutation, String firstName, String lastName, String leadSrc, String title, String department, String email, String mobNo) {
		
	}

}
