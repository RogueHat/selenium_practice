package runners;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class GoogleRipper {
	 public static void main(String[]args) throws MalformedURLException, IOException, InterruptedException {
		 PrintStream throwawayfile = new PrintStream("fuckYouLogfile");
		 System.setErr(throwawayfile);
		 
		 URL url = new URL("https://raw.githubusercontent.com/CodefagoCbrgLyIyM/Alphabet/master/keywords");
		 Scanner s = new Scanner(url.openStream());
		 
		 List<String> q1 = new ArrayList<String>();
		 List<String> q2 = new ArrayList<String>();
		 
		 for(int i=0; s.hasNext(); i++) {
			 if(i % 2 == 0)
				 q1.add(s.nextLine());
			 else
				 q2.add(s.nextLine());
		 }
		 
		 s.close();
		 
		 LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<String>();
		 List<Thread> threads = new ArrayList<Thread>();
		 
		 Reader r1 = new Reader(q1, lbq);
		 threads.add(r1);
		 
		 
		 Reader r2 = new Reader(q2, lbq);
		 threads.add(r2);
		 
		 
		 for(int i=0; i<10; i++)
			 threads.add(new Clicker(lbq));
			 
		 for(Thread t: threads)
			 t.start();
		 
		 for(Thread t: threads)
			 t.join();
		 
	 }
}
