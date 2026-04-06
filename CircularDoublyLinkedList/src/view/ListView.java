package view;

import controller.ListController;

public class ListView {
	public static void main(String[] args) {
		try {
			ListController listCrtl = new ListController();
			System.out.println(listCrtl.testList());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}