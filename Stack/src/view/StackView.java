package view;

import controller.StackController;

public class StackView {
	public static void main(String[] args) {
		try {
			StackController stackController = new StackController();
			System.out.println(stackController.testStack());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}