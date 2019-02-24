package Exercise_2;

public class RunnableFinder implements Runnable {
	Double[] row;
	int rowNumber;
	Double[] rowMaxes;
	
	public RunnableFinder(Double[] row, Double[] rowMaxes, int rowNumber) {
		this.row = row;
		this.rowMaxes = rowMaxes;
		this.rowNumber = rowNumber;
	}

	@Override
	public void run() {
		rowMaxes[rowNumber] = 0.0;
		for(int i = 0; i < row.length; i++) {
			if(row[i] > rowMaxes[rowNumber]) {
				rowMaxes[rowNumber] = row[i];
			}
		}
		
	}
	
}
