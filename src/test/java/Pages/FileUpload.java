package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUpload {
	
	WebDriver driver;
	
	public FileUpload(WebDriver driver) {
		this.driver=driver;
	}
By title=By.xpath("//h1[text()='File upload']");
By choose=By.xpath("//button[text()='Choose']");
By fileUploadField=By.id("file-upload-field");
By reset=By.xpath("//button[text()='Reset']");

public String getTitle() {
	return driver.findElement(title).getText();
}

public String fileUpload() {
	String filePath="C:\\Users\\HP\\Desktop\\Daily Status Reports\\15-10-2024\\Dividend Challan.pdf";
	driver.findElement(fileUploadField).sendKeys(filePath);
	return driver.findElement(fileUploadField).getAttribute("value");
}
public String resetButtonFunctionality() {
	driver.findElement(reset).click();
	return driver.findElement(fileUploadField).getAttribute("placeholder");
}
}
