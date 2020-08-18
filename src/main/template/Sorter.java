package main.template;

public abstract class Sorter {

	protected int[] array;
	
	protected boolean startedSort = false;
	protected boolean sorted = false;
	
	protected double startTime;
	protected double endTime;
	
	protected int swapCounter = 0;
	protected int comparisonCounter = 0;
	
	public Sorter() {
		super();
	}
		
	public abstract void tick();

	protected int maxTPS = 6000;
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public void sort(int[] array) {
		this.array = array;
		startTime = System.currentTimeMillis();
		startedSort = true;
	}
	
	public boolean startedSort() {
		return startedSort;
	}
	
	public boolean isSorted() {
		return sorted;
	}
	
	public int getNumSwaps() {
		return swapCounter;
	}
	
	public double getStartTime() {
		return startTime;
	}
	
	public double getEndTime() {
		return endTime;
	}
	
	public double getTimeElapsedMillis() {
		return endTime - startTime;
	}
		
	public int getMaxTPS() {
		return maxTPS;
	}
	
	public double getTPS() {
		return 1000000000D / maxTPS;
	}
	
	public int getNumCompare() {
		return comparisonCounter;
	}
	
	public int getArrayLength() {
		return array.length;
	}
	
	public int[] getArray() {
		return array;
	}
}
