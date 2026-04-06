package view;

import controller.QueueController;

public class QueueView {
	public static void main(String[] args) {
		try {
			QueueController queueController = new QueueController();
			System.out.println(queueController.testQueue());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}