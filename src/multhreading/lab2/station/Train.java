package multhreading.lab2.station;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Train implements Runnable{
	private int capacity;
	private BlockingQueue<Person> list;

	public Train(int capacity, BlockingQueue<Person> list) {
		this.capacity = capacity;
		this.list = list;
		new Thread(this, "").start();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public void run() {
		for(int i = 0; i < capacity; i++) {
			try {
				list.take();
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("Caught Interupted Exeption in Train");
			}
		}
		
		System.out.println("Train dispatch with " + capacity + " passangers aboard");
		
		new Train(new Random().nextInt(9000) + 1000, list);
	}
}
