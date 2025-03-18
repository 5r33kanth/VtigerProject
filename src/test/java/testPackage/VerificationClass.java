package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class VerificationClass extends BaseClass {
	
	@Test
	public void verify() {
		
		Assert.assertEquals(true, true);
		Assert.assertEquals(5, 5);
		Assert.assertEquals("Athulya", "Athulya");
		
		Assert.assertNotEquals(true, false);
		Assert.assertNotEquals(7, 3);
		
		Assert.assertNull(null);
		Assert.assertNotNull("Hari");
		
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		
//		Assert.fail();
		
	}

}
