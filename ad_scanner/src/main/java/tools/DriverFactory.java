package tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class DriverFactory {
	public static WebDriver getDriver() {
		System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");		
		WebDriver dr = new FirefoxDriver();
		
//		WebDriver dr = new HtmlUnitDriver(true);
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return dr;
	}
	
	public static WebDriver getNonBlockingDriver() {
		WebDriver dr = new HtmlUnitDriver();
		dr.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		return dr;
	}
}
