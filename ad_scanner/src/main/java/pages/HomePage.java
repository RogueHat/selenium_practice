package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {

	By queryBoxBy = By.name("q");
	
	public HomePage(WebDriver dr) {
		super(dr);
	}
	
	public HomePage(Page p) {
		super(p);
	}
	
	public HomePage goToHomePage() {
		dr.navigate().to("https://www.google.com");
		return new HomePage(dr);
	}
	
	public ResultPage sendQuery(String q) {
		WebElement textBox = dr.findElement(queryBoxBy);
		textBox.clear();
		textBox.sendKeys(q+Keys.ENTER);
		return new ResultPage(dr);
	}
}
