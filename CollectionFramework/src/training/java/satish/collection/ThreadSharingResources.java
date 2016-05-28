package training.java.satish.collection;
class PrintNumbers {
	   public void printCount(){
	    try {
	         for(int i = 5; i > 0; i--) {
	            System.out.println("Counter   ---   "  + i );
	         }
	     } catch (Exception e) {
	         System.out.println("Thread  interrupted.");
	     }
	   }

	}

	class SampleThread extends Thread {
	   private Thread t;
	   private String threadName;
	   PrintNumbers  pn;

	   SampleThread( String name,  PrintNumbers pd){
	       threadName = name;
	       pn = pd;
	   }
	   public void run() {
	     synchronized(pn) {
	        pn.printCount();
	     }
	     System.out.println("Thread " +  threadName + " exiting.");
	   }

	   public void start ()
	   {
	      System.out.println("Starting " +  threadName );
	      if (t == null)
	      {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }

	}

	public class ThreadSharingResources {
	   public static void main(String args[]) {

	      PrintNumbers pn = new PrintNumbers();

	      SampleThread T1 = new SampleThread( "Thread - 1 ", pn );
	      SampleThread T2 = new SampleThread( "Thread - 2 ", pn );

	      T1.start();
	      T2.start();

	      // wait for threads to end
	      try {
	         T1.join();
	         T2.join();
	      } catch( Exception e) {
	         System.out.println("Interrupted");
	      }
	   }
	}