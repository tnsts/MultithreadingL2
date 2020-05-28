package multhreading.lab2.station;

import java.util.Random;
import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) {
		BlockingQueue<Person> queue = new LinkedBlockingDeque<>();

		ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
		
		Random rand = new Random();
		
		ses.scheduleAtFixedRate(
				new Runnable() {
					public void run() {
						new Bus(rand.nextInt(90) + 10, queue);
					}
				},
				0, rand.nextInt(1000), TimeUnit.MILLISECONDS
			);
		
		
		CompletableFuture.runAsync(
				new Runnable() {
					public void run() {
						new Train(rand.nextInt(9000) + 1000, queue);
					}
				}
			);
	}
}
