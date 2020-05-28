package multhreading.lab2.station;

import java.util.concurrent.BlockingQueue;

public class Bus implements Runnable{
	private int capacity;
	private BlockingQueue<Person> list;

	public Bus(int capacity, BlockingQueue<Person> list) {
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
				list.put(new Person());
			} catch (InterruptedException e) {
				System.out.println("Caught Interupted Exeption in Bus");
			}
		}
		
		System.out.println("New bus with " + capacity + " passangers aboard");
	}
}
