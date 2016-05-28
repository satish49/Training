package training.java.satish.collection;

public class SynchronusAndAynchronus {
	/*
	 * I'll implemment Synnchronus and Asynchronus using Threads
	 * 
	 * Synchronus:
	 * 		with the help of join() method, the current running thread wait until new thread complete. It's synchronus
	 * 
	 * Asnchronus:
	 * 		general way to create thread and start. So current not wait for completion of new thread. so It's Asynchronus
	 * 
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * Two thread t1 and t2. main thread wait for completion of t1 thread. 
		 * It's synchronus
		 * 
		 */
		ThreadOne tOne=new ThreadOne();
		Thread t1=new Thread(tOne);
		
		ThreadTwo tTwo=new ThreadTwo();
		Thread t2=new Thread(tTwo);
		
		
		System.out.println("Synchronus operation");
		System.out.println("--------------------");
		t1.start();
		t1.join();		
		t2.start();
		
		
		/*
		 * Two more threads to show case Asynchronus.
		 * Here main thread not waiting for t1A thread
		 * 
		 */
		ThreadOne tOneA=new ThreadOne();
		Thread t1A=new Thread(tOneA);
		
		ThreadTwo tTwoA=new ThreadTwo();
		Thread t2A=new Thread(tTwoA);
		
		
		System.out.println("\n\nAsynchronus operation");
		System.out.println("----------------------");
		t1A.start();
		t2A.start();
		
		
		
	}
}


class ThreadOne implements Runnable
{

	@Override
	public void run() {

		try {
			System.out.println("**************Sleep ThreadOne for 5 Seconds*************");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("This is ThreadOne run() method");
	}
}

class ThreadTwo implements Runnable
{

	@Override
	public void run() {
		System.out.println("This is ThreadTwo run() method");
	}
}

