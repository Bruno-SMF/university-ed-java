package view;

import controller.FactorialController;

public class Factorial {
	public static void main(String[] args) {
		int number = 7;
		FactorialController factorial = new FactorialController();
		System.out.println(factorial.calculateFactorial(number));
	}
}