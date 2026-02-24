package controller;

public class QuickSort {
	
	public void quickSort(int[] array) {
		sortArray(array, 0, array.length - 1);
	}
	
	private void sortArray(int[] array, int start, int end) {
		if (end > start) {
			int indexPivot = splitArray(array, start, end);
			sortArray(array, start, indexPivot - 1);
			sortArray(array, indexPivot + 1, end);
		}
	}
	
	private int splitArray(int[] array, int start, int end) {
		int pivot = array[start];
		int leftPointer = start + 1;
		int rightPointer = end;
		
		while (leftPointer <= rightPointer) {
			while (leftPointer <= rightPointer && array[leftPointer] <= pivot) {
				leftPointer++;
			}
			
			while (rightPointer >= leftPointer && array[rightPointer] > pivot) {
				rightPointer--;
			}
			
			if (leftPointer < rightPointer) {
				switchValues(array, leftPointer, rightPointer);
			}
		}
		
		switchValues(array, start, rightPointer);
		return rightPointer;
	}
	
	private void switchValues(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}