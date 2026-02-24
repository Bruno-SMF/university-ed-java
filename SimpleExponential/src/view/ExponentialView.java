package view;

import controller.ExponentialController;

public class ExponentialView {
	public static void main(String[] args) {
		int number = 5;
		int power = 5;
		
		ExponentialController exp = new ExponentialController();
		System.out.println(exp.calculateExponential(number, power));
	}
}