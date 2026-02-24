package controller;

public class PrintNumber {
	public void print(int num) {
		if (num < 10) {
			System.out.println("Number: " + num);
			print(num + 1);
		}
		return;
	}
}