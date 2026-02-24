package view;

import java.util.Scanner;
import controller.QuickSort;
import controller.BubbleSort;
import controller.MergeSort;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();
		System.out.println("ARRAY SORTER");

		System.out.println();
		System.out.println("Enter the size of your array:");		
		System.out.println();
        int input = scanner.nextInt();
		int[] array = new int[input];
		System.out.println();
		
		for (int i = 0; i < input; i++) {
			System.out.println("Enter the value #" + (i + 1) + ":");
			array[i] = scanner.nextInt();
		}
		
		System.out.println();
		System.out.println("Choose the sorting algorithm:");
        System.out.println("1 - Quick Sort");
        System.out.println("2 - Bubble Sort");
        System.out.println("3 - Merge Sort");
		System.out.println();
		
        int option = scanner.nextInt();
		System.out.println();
		
		switch (option) {
			case 1:
				QuickSort quick = new QuickSort();
				System.out.println("Sorting using Quick Sort:");
				quick.quickSort(array);
				break;
			case 2:
				BubbleSort bubble = new BubbleSort();
				System.out.println("Sorting using Bubble Sort:");
				bubble.bubbleSort(array);
				break;
			case 3:
				MergeSort merge = new MergeSort();
				System.out.println("Sorting using Merge Sort:");
				merge.mergeSort(array);
				break;
			default:
				System.out.println("Invalid choice!");
				return;
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}