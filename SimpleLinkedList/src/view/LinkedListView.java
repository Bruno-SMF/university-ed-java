package view;

import controller.LinkedListController;

public class LinkedListView {
	public static void main(String[] args) {
		try {
			LinkedListController obj = new LinkedListController();
			System.out.println(obj.testLinkedList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}