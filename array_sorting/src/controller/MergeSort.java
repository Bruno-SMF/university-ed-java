package controller;

public class MergeSort {
	public void mergeSort(int[] array) {
		sortArray(array, 0, array.length - 1);
	}
	
	public void sortArray(int[] array, int start, int end) {
		int middle;
		if (start < end) {
			middle = (start + end) / 2;
			sortArray(array, start, middle);
			sortArray(array, middle + 1, end);
			arrangeArray(array, start, middle, end);
		}
	}
	
	public void arrangeArray(int[] array, int start, int middle, int end) {
		int[] auxArray = new int[array.length];
		int auxArrayPointer = start;
		int leftArrayPointer = start;
		int rightArrayPointer = middle + 1;
		
		while (leftArrayPointer <= middle && rightArrayPointer <= end) {
			if (array[leftArrayPointer] <= array[rightArrayPointer]) {
				auxArray[auxArrayPointer] = array[leftArrayPointer];
				leftArrayPointer++;
			} else {
				auxArray[auxArrayPointer] = array[rightArrayPointer];
				rightArrayPointer++;
			}
			auxArrayPointer++;
		}
		
		while (leftArrayPointer <= middle) {
			auxArray[auxArrayPointer] = array[leftArrayPointer];
			leftArrayPointer++;
			auxArrayPointer++;
		}
		
		while (rightArrayPointer <= end) {
			auxArray[auxArrayPointer] = array[rightArrayPointer];
			rightArrayPointer++;
			auxArrayPointer++;
		}
		
		for (int i = start; i <= end; i++) {
			array[i] = auxArray[i];
		}
	}
}