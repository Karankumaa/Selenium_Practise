package Pages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchWindow {
WebDriver driver;
	
	public SwitchWindow(WebDriver driver) {
		this.driver=driver;
	}
	
	By title=By.xpath("//h1[text()='Switch Window']");
	By newTab=By.id("new-tab-button");
	By newTabTitle=By.xpath("//h1[text()='Welcome to Formy']");
	By alert=By.id("alert-button");
	
	//get title
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public String switchWindowHandling() {
		String txt = null;
		String parentHandle=driver.getWindowHandle();
		driver.findElement(newTab).click();
		Set<String>windowHandles=driver.getWindowHandles();
		for(String child:windowHandles) {
			if(!parentHandle.equals(child)) {
				driver.switchTo().window(child);
				txt=driver.findElement(newTabTitle).getText();
				driver.close();
			}
		}
		driver.switchTo().window(parentHandle);
		return txt;	
	}
	public String getAlertText() {
		
		driver.findElement(alert).click();
		Alert alert=driver.switchTo().alert();
		String txt=alert.getText();
		alert.accept();
		return txt;
	}
	

}
