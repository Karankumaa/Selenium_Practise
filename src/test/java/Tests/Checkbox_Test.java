package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.Checkbox_Page;

public class Checkbox_Test extends BaseTest {

    private Checkbox_Page checkbox;

    @BeforeClass
    public void baseSetUp() {
    	super.baseSetUp();
        checkbox = home.goToCheckboxPage();
        System.out.println("Checkbox_Test] Web Form Page opened successfully.");
    }

    @Test(priority = 1)
    public void verifyTitle() {
        String actual = checkbox.getTitle();
        Assert.assertEquals(actual, "Checkboxes");
    }

    @Test(priority = 2)
    public void verifySelectionOfAllCheckboxes() {
        boolean[] actual = checkbox.selectAllCheckboxes();
        boolean[] expected = {true, true, true}; // Ensure this matches the actual number of checkboxes
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 3)
    public void verifySelectionOfAlternateCheckboxes() {
        boolean[] actual = checkbox.selectAlternateCheckboxes();
        boolean[] expected = {true, true}; // Adjust based on the actual selection logic
        Assert.assertEquals(actual, expected);
    }
  }
