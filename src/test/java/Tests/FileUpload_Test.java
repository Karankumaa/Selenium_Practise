package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.FileUpload;

public class FileUpload_Test extends BaseTest{
	private FileUpload fileUpload;

    @BeforeClass
    public void baseSetUp() {
    	super.baseSetUp();
    	fileUpload = home.goToFileUploadPage();
        System.out.println("FileUpload_Test] FileUpload Page opened successfully.");
 
    }
    @Test(priority=1)
    public void verifyTitle() {
    String actualTitle=	fileUpload.getTitle();
    Assert.assertEquals(actualTitle, "File upload");
    }
    @Test(priority=2)
    public void verifyFileUpload() {
    String actual=	fileUpload.fileUpload();
    String expected="C:\\Users\\HP\\Desktop\\Daily Status Reports\\15-10-2024\\Dividend Challan.pdf";
    Assert.assertEquals(actual, expected);
    }
    @Test(priority=3)
    public void verifyResetBtn() {
    String actual=	fileUpload.resetButtonFunctionality();
    Assert.assertEquals(actual,"Choose a file...");
    }
}
