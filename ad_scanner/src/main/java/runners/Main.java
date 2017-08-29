package runners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.HomePage;
import pages.ResultPage;

public class Main {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
		
		WebDriver dr = new FirefoxDriver();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		HomePage p = new HomePage(dr);
		p.goToHomePage();
		
		ResultPage rp = p.sendQuery("insurance");
		System.out.println(rp.getAdUrls());
		
		rp.close();
	}

}
