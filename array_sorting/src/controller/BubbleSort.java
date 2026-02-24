package controller;

public class BubbleSort {
	public void bubbleSort(int[] array) {
		int aux = 0;
		for (int i = 0; i < (array.length - 1); i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					aux = array[i];
					array[i] = array[j];
					array[j] = aux;
				}
			}
		}
	}
}