package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebForm_Page {
protected WebDriver driver;
	
	public WebForm_Page(WebDriver driver) {
		this.driver=driver;
	}
	By title=By.xpath("//h1[text()='Complete Web Form']");
	By fname=By.id("first-name");
	By lname=By.id("last-name");
	By jobTitle=By.id("job-title");
	By HighestLevelEdu=By.id("radio-button-1");
	By sex=By.id("checkbox-1");
	By experience=By.id("select-menu");
	By datePicker=By.id("datepicker");
	By datePickerTitle=By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']");
	By prev=By.cssSelector("div.datepicker-days table.table-condensed thead tr:nth-child(2) th:nth-child(1)");
	By next=By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']");
	By submit=By.xpath("//a[text()='Submit']");
	By successMsg=By.xpath("//div[@class='alert alert-success']");
	By homepageBtn=By.xpath("//a[text()='Formy']");
	
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public String enterAndReturnInput(WebElement el,String input) {
		el.sendKeys(input);
		String fn=el.getAttribute("value");
		el.clear();
		return fn;
	}
	public String enterFirstName(String data) {
		WebElement el=driver.findElement(fname);
		String fn=enterAndReturnInput(el,data);
		return fn;
	}
	public String enterLastName(String data) {
		WebElement el=driver.findElement(lname);
		String ln=enterAndReturnInput(el,data);
		return ln;
	}
	public String enterJobTitle(String data) {
		WebElement el=driver.findElement(jobTitle);
		String jobTitle=enterAndReturnInput(el,data);
		return jobTitle;
	}
	public boolean selectHighestLevelEducation() {
		driver.findElement(HighestLevelEdu).click();
		return driver.findElement(HighestLevelEdu).isSelected();
	}
	public boolean selectGender() {
		driver.findElement(sex).click();
		return driver.findElement(sex).isSelected();
	}
	public String selectYearsOfExperience(String exp) {
		WebElement el=driver.findElement(experience);
		Select sel=new Select(el);
		sel.selectByVisibleText(exp);
		String option=sel.getFirstSelectedOption().getText();
		return option;
	}
	public String selectDate(String expectedTitle,int day)  {
		WebElement picker=driver.findElement(datePicker);
		picker.click();
		WebElement nextBtn=driver.findElement(next);
		String actualTitle=driver.findElement(datePickerTitle).getText();
		
		while(!actualTitle.equals(expectedTitle)) {
			nextBtn.click();
			actualTitle=driver.findElement(datePickerTitle).getText();
		}
		By date=By.xpath("//td[@class='day' and text()='"+day+"']");
		driver.findElement(date).click();
		return picker.getAttribute("value");
	}
	public String submitForm() {
		driver.findElement(submit).click();
		return driver.findElement(successMsg).getText();
	}
	public HomePage navigateToHomepage() {
		driver.findElement(homepageBtn).click();
		return new HomePage(driver);
	}
}
