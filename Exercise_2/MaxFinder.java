package Exercise_2;

import java.util.Arrays;

public class MaxFinder {

	public static void main(String[] args) {
		
		// Create a 2D Array with 100 rows and 50 columns
		int nRows = 100;
		int nCols = 50;
		Double[][] randArray = new Double[nRows][nCols];
//		Double[] topNumbersOfEachRow = new Double[nRows];

		// Populate the randArray with random numbers
		for (int r = 0; r < nRows; r++) {
			for (int c = 0; c < nCols; c++) {
				randArray[r][c] = Math.random();
			} // End of inner for
		} // End of outer for

		// Find the max using loops
		Double temp = 0.0;
		for (int x = 0; x < nRows; x++) {
			for (int y = 0; y < nCols; y++) {
				if (temp <= randArray[x][y]) {
					temp = randArray[x][y];
				} // End of if

				// Print out the whole array to double-check if the temp
				// variable is correct
				// System.out.println(randArray[x][y]);

			} // End of inside loop
		} // End of outer loop
		
		// Threads solution
		Double[] rowMaxes = new Double[nRows];
		Thread[] threads = new Thread[nRows];
		for(int i = 0; i < nRows; i++) {
			threads[i] = new Thread(new RunnableFinder(randArray[i],rowMaxes,i));
			threads[i].start();
		}
		try {
			for(int i = 0; i < nRows; i++) {
				threads[i].join();
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		Double[] finalVal = new Double[1];
		Thread finalThread = new Thread(new RunnableFinder(rowMaxes, finalVal, 0));
		finalThread.start();
		try {
			finalThread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(finalVal[0]);
		
		

//		for(int v = 0; v < nRows; v++) {
//			Double tempNumbToArray = 0.0;
//			for(int u = 0; u < nCols; u++) {
//				if(tempNumbToArray <= randArray[v][u]) {
//					topNumbersOfEachRow[v] = randArray[v][u];
//				}
//			}
//		}
		
		
		// Print the maximum number
//		System.out.println("The maximum number is " + temp);
//		for(int o = 0; o < nRows; o++) {
//			System.out.println(topNumbersOfEachRow[o]);
//		}


	}// End of main

}// End of class
