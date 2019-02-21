package Exercise_1;

public class RunnableTest {
	@SuppressWarnings("unused")
	private static class PointlessPrint implements Runnable, java.lang.Runnable {
		private String message;
		private int n;
		static PointlessPrint p = new PointlessPrint("Hello", 100);
		static Thread t = new Thread(p);
		public PointlessPrint(String message, int n) {
			this.message = message;
			this.n = n;
		}

		@SuppressWarnings("static-access")
		public void run() {
			for (int i = 0; i < n; i++) {
				System.out.println(i + "/" + n + " " + message);
				try {
					// sleep thread for half second
					System.out.println("Stop for 2 seconds to rest. Poor thread.");
					t.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public static void main(String[] args) throws InterruptedException {

			// start the thread by invoking the run() method
			t.start();
		}
	}
}
