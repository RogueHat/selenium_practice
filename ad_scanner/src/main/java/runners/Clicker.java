package runners;

import java.util.concurrent.LinkedBlockingQueue;

import org.openqa.selenium.WebDriver;

import tools.DriverFactory;

public class Clicker extends Thread {
	private LinkedBlockingQueue <String> adUrls;
	private WebDriver dr;
	
	public Clicker(LinkedBlockingQueue<String> lbq) {
		adUrls = lbq;
		dr = DriverFactory.getNonBlockingDriver();
	}
	
	public void run() {
		while(true) {
			try {
				String url = adUrls.take();
				dr.navigate().to(url);
				System.out.println("Clicked:\t"+url);
			} catch (InterruptedException e) {
				e.printStackTrace();
				dr.close();
				dr = DriverFactory.getNonBlockingDriver();
			}
		}
	}

}
