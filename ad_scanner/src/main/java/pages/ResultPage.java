package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage extends HomePage {

	By liAdsBy = By.cssSelector(".ads-ad");
	
	public ResultPage(WebDriver dr) {
		super(dr);
	}

	public ResultPage(Page p) {
		super(p);
	}
	
	public List<String> getAdUrls(){
		List<WebElement> listElements = dr.findElements(liAdsBy);
		return listElements.stream().map(
				x -> x.findElements(By.cssSelector("h3 a")).get(0).getAttribute("href")
				).collect(Collectors.toList());
	}
}
