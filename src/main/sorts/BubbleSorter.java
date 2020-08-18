package main.sorts;

import main.template.Dialog;
import main.template.Sorter;

public class BubbleSorter extends Sorter {

	private int i = 0;
	private int j = 0;
	
	public void tick() {
		if(sorted || !startedSort) return;
		
		if(i < array.length) {
			if(array[j] > array[j + 1]) {
				swap(array, j, j + 1);
				swapCounter++;
			}
			comparisonCounter++;
			endTime = System.currentTimeMillis();

			j++;
			
			
			if(j >= array.length - i - 1) {
				i++;
				j = 0;				
			}
		} else {
			sorted = true;
			maxTPS = 30;
		}
	}
	
	public static void main(String[] args) {
		new Dialog(new BubbleSorter());
	}
}
