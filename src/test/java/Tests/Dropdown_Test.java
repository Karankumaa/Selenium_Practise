package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Dropdown_Page;

public class Dropdown_Test extends BaseTest{

    private Dropdown_Page dropdown;

    @BeforeClass
    public void baseSetUp() {
    	super.baseSetUp();
        dropdown = home.goToDropdownPage();
        System.out.println("Dropdown_Test] Dropdown Page opened successfully.");
    }

    @Test(priority = 1)
    public void verifyTitle() {
        String actual = dropdown.getTitle();
        Assert.assertEquals(actual, "Dropdown");
    }
    
    @Test(priority=2)
    public void verifyDropdownOptionsSize() {
    int size=	dropdown.getAllOptions();
    Assert.assertEquals(size, 15);
    }
    
    @Test(priority=3)
    public void verifyOptionIsSelected() {
    boolean flag=dropdown.selectOptionAndCheckNavigatedToButtonsPage();
    Assert.assertEquals(flag, true);
    }
    
}
