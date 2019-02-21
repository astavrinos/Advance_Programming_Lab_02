package Exercise_1;
public class ThreadTest extends Thread {

	public ThreadTest() {
//		super(a);
		this.getName();
	}

	public void run() {
//		int x = 0;
//		while (currentThread().isInterrupted() == false) {

		// Create a for loop that exports a message
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "/" + 10 + " - " + getName());
			// thread.sleep() needs try-catch or Throw InterruptedException
			try {
				System.out.println("Stop for 2 seconds to rest. Poor thread.");
				// Sleep thread for half second
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // End of try-catch
		} // End of for
//			System.out.println(x);
//		} // End of while loop
	}// End of run

	public static void main(String args[]) {
		// Calling ThreadTest class which extends threads. So we do not need to create a
		// new Thread
		ThreadTest[] t = new ThreadTest[5];
		for(int i = 0; i < t.length; i++) {
			t[i] = new ThreadTest();
			t[i].start();
		}
		for(int i = 0; i < t.length; i++) {
			try {
				System.out.println("Can I join you guys? "
						+ "I will ask until you say yes.");
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\nMain method executed by main thread.");
	}// End of main
}// End of class