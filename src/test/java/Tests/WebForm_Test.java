package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.WebForm_Page;

public class WebForm_Test extends BaseTest {
    private WebForm_Page web;

    @BeforeClass
    public void baseSetUp() {
    	super.baseSetUp();
        web = home.goToWebFormPage();
        System.out.println("[WebForm_Test] Web Form Page opened successfully.");
    }

    @Test(priority = 1)
    public void verifyTitle() {
        String actual = web.getTitle();
        Assert.assertEquals(actual, "Complete Web Form");
    }

    @Test(priority = 2, dataProvider = "dataprovider1")
    public void verifyFirstName(String fnames) {
        String actual = web.enterFirstName(fnames);
        Assert.assertEquals(actual, fnames);
    }

    @DataProvider
    public Object[][] dataprovider1() {
        return new Object[][] { { "Bhushan" }, { "Karan" }, { "Ram" } };
    }

    @Test(priority = 3)
    public void verifyLastName() {
        String actual = web.enterLastName("Bhale");
        Assert.assertEquals(actual, "Bhale");
    }

    @Test(priority = 4)
    public void verifyJobTitle() {
        String actual = web.enterJobTitle("QA");
        Assert.assertEquals(actual, "QA");
    }

    @Test(priority = 5)
    public void verifySelectHighLevelEducation() {
        Assert.assertTrue(web.selectHighestLevelEducation(), "Highest Level Education checkbox was not selected.");
    }

    @Test(priority = 6)
    public void verifysSelectingGender() {
        Assert.assertTrue(web.selectGender(), "Gender checkbox was not selected.");
    }

    @Test(priority = 7)
    public void verifySelectYearsOfExperience() {
        Assert.assertEquals(web.selectYearsOfExperience("2-4"), "2-4", "Years of experience selection failed.");
    }

    @Test(priority = 8)
    public void verifySelectingDate() {
        String actual = web.selectDate("October 2026", 15);
        System.out.println("Selected Date: " + actual);
        Assert.assertEquals(actual, "10/15/2026", "Date selection failed.");
    }

    @Test(priority = 9)
    public void verifySubmission() {
        String alertMessage = web.submitForm();
        Assert.assertEquals(alertMessage, "The form was successfully submitted!", "Form submission failed.");
    }

    
}
