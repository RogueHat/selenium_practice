package pages;

import org.openqa.selenium.WebDriver;

public class Page {
	
	protected WebDriver dr;
	
	public Page(WebDriver dr) {
		this.dr = dr;
	}
	
	public Page(Page p) {
		this.dr = p.getDr();
	}

	public WebDriver getDr() {
		return dr;
	}

	public void setDr(WebDriver dr) {
		this.dr = dr;
	}
	
	public void close() {
		dr.close();
	}
}
