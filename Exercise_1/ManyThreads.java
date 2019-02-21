package Exercise_1;

public class ManyThreads implements Runnable {

	public static void main(String[] args) {
		int nThreads = 2;
		Thread[] threads = new Thread[nThreads];
		for(int i = 0; i < nThreads; i++) {
			PointlessPrint p = new PointlessPrint("I am thread " + i,10);
			threads[i] = new Thread(p);
			threads[i].start();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
