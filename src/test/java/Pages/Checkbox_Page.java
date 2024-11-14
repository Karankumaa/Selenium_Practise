package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox_Page {

	protected WebDriver driver;
	public Checkbox_Page(WebDriver driver) {
		this.driver=driver;
	}
	By title=By.xpath("//h1[text()='Checkboxes']");
	By allCheckboxes=By.cssSelector("input[type='checkbox']");
	
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public boolean[] selectAllCheckboxes() {
		List<WebElement>list=driver.findElements(allCheckboxes);
		boolean[]arr=new boolean[list.size()];
		for(int i=0;i<list.size();i++) {
			list.get(i).click();
			arr[i]=list.get(i).isSelected();
		}
		return arr;
	}
	
	public boolean[] selectAlternateCheckboxes() {
		List<WebElement>list=driver.findElements(allCheckboxes);
		boolean[]arr=new boolean[2];
		int index=0;
		for(int i=0;i<list.size();i++) {
			if(i%2==0) {
				//list.get(i).click();
				list.get(i).click();
				arr[index++]=list.get(i).isSelected();
			}
		}
		return arr;
	}
}
