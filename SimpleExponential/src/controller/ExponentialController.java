package controller;

public class ExponentialController {
	public int calculateExponential(int base, int power) {
		if (power == 0) {
			return 1;
		} else {
			return base * calculateExponential(base, power - 1);
		}
	}
}