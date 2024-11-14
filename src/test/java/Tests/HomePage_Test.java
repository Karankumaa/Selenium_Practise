package Tests;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomePage_Test extends BaseTest{


	@Test()
	public void verifyTitle() {
		System.out.println(home.getPageTitle());
		Assert.assertEquals(home.getPageTitle(), "Formy");
	}
	
}
