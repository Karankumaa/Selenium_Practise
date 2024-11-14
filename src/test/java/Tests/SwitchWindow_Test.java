package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.FileUpload;
import Pages.SwitchWindow;

public class SwitchWindow_Test extends BaseTest {

	private SwitchWindow window;

    @BeforeClass
    public void baseSetUp() {
    	super.baseSetUp();
    	window = home.goToSwitchWindowPage();
        System.out.println("SwitchWindow_Test] SwitchWindow_Test Page opened successfully.");
 
    }
    
    @Test(priority=1)
    public void verifyTitle() {
    String actualTitle=	window.getTitle();
    Assert.assertEquals(actualTitle, "Switch Window");
    }
    @Test(priority=2)
    public void verifyWindowHandling() {
    String actualTitle=	window.switchWindowHandling();
    Assert.assertEquals(actualTitle, "Welcome to Formy");
    }
    
    @Test(priority=3)
    public void verifyAlertText() {
    String actualTitle=	window.getAlertText();
    Assert.assertEquals(actualTitle, "This is a test alert!");
    }

    
}
