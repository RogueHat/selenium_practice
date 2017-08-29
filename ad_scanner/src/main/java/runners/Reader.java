package runners;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.ResultPage;
import tools.DriverFactory;

public class Reader extends Thread {
	private List<String> queries;
	private LinkedBlockingQueue <String> adUrls;
	private Random rng;

	public Reader(List<String> q, LinkedBlockingQueue<String> lbq) {
		queries = q;
		adUrls = lbq;
		rng = new Random();
	}

	public void run() {
		WebDriver dr = DriverFactory.getDriver();
		HomePage p = new HomePage(dr);
		

		while (true) {
			int idx = rng.nextInt(queries.size());
			p.goToHomePage();
			ResultPage rp = p.sendQuery(queries.get(idx));
			List<String> urls = rp.getAdUrls();
			for (String url : urls)
				try {
					adUrls.put(url);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println(adUrls.size());
		}
	}
}
