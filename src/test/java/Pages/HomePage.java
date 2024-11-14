package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	protected WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By webForm=By.xpath("//a[text()='Complete Web Form' and @class='btn btn-lg']");
	public By checkbox=By.xpath("//a[@class='btn btn-lg' and text()='Checkbox']");
	public By dropdown=By.xpath("//a[@class='btn btn-lg' and text()='Dropdown']");
	public By fileUpload=By.xpath("//a[@class='btn btn-lg' and text()='File Upload']");
	public By switchWindow=By.xpath("//a[@class='btn btn-lg' and text()='Switch Window']");
	public void scrollToElement(WebElement el) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",el );
	}
	
	public WebForm_Page goToWebFormPage() {
		WebElement el=driver.findElement(webForm);
		scrollToElement(el);
		el.click();
		return new WebForm_Page(driver);
	}
	public Checkbox_Page goToCheckboxPage() {
		driver.findElement(checkbox).click();
		return new Checkbox_Page(driver);
	}
	public Dropdown_Page goToDropdownPage() {
		driver.findElement(dropdown).click();
		return new Dropdown_Page(driver);
	}
	public FileUpload goToFileUploadPage() {
		driver.findElement(fileUpload).click();
		return new FileUpload(driver);
	}
	public SwitchWindow goToSwitchWindowPage() {
		WebElement el=driver.findElement(switchWindow);
		scrollToElement(el);
		el.click();
		return new SwitchWindow(driver);
	}
	public String getPageTitle() {
		return driver.getTitle();
	}

}
