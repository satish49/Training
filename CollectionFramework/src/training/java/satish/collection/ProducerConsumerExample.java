package training.java.satish.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {

	public static void main(String[] args) {

		//this ProducerClass used to insert data to Queue
		ProducerClass pc = new ProducerClass();
		Thread tP = new Thread(pc);
		tP.setName("Producer   ");

		//this ConsumerClass used to get data from Queue
		ConsumerClass cc = new ConsumerClass();
		Thread tC = new Thread(cc);
		tC.setName("Consumer 1 ");

		//start threads
		tP.start();

		tC.start();
		
		//one more consumer
		ConsumerClass cc2=new ConsumerClass();
		Thread tC2=new Thread(cc2);
		tC2.setName("Consumer 2 ");
		tC2.start();

	}
}
/*
 * This class maintain actual data to be blockingQueue
 */
class SharedDataClass {
	public final static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(); // 5
}

/*
 * generate random number and add to queue
 */
class ProducerClass implements Runnable {

	@Override
	public void run() {
		BlockingQueue<Integer> queue = SharedDataClass.blockingQueue;

		// here we add random value to List
		for (int i = 0; i < 10; i++) {
			Random rn = new Random();
			int value = rn.nextInt(10);

			try {
				synchronized (this) {
					queue.put(value);
					System.out.println(Thread.currentThread().getName()+"  put==" + value);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

/*
 * take data from blockingQueue
 */
class ConsumerClass implements Runnable {

	@Override
	public   void run() {
		BlockingQueue<Integer> queue = SharedDataClass.blockingQueue;
		while (true) {

			try {
				synchronized (this) {
					Integer data = queue.take();
					System.out.println(Thread.currentThread().getName()+"  take==" + data);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}