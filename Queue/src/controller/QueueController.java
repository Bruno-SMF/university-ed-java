package controller;

import model.Queue;

public class QueueController {
	public String testQueue() throws Exception {
		Queue queue = new Queue();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
		
		return queue.toString();
	}
}