package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dropdown_Page {

	WebDriver driver;

	public Dropdown_Page(WebDriver driver) {
		this.driver=driver;
	}

	By title=By.xpath("//h1[text()='Dropdown']");
	By dropdownMenu=By.id("dropdownMenuButton");
	By buttons=By.xpath("//div[@class='dropdown-menu show']/a[text()='Buttons']");
	By options=By.xpath("//div[@class='dropdown-menu show']/a");
	By primary=By.xpath("//button[text()='Primary']");

	public String getTitle() {
		String txt=driver.findElement(title).getText();
		return txt;
	}
	public int getAllOptions() {
		driver.findElement(dropdownMenu).click();
		int length=	driver.findElements(options).size();
		return length;
	}
	public boolean selectOptionAndCheckNavigatedToButtonsPage() {
		WebElement el=driver.findElement(buttons);
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView();", el);
		el.click();
		return driver.findElement(primary).isDisplayed();
	}

}
