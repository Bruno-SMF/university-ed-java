package model;

import model.Node;
import java.lang.Exception;

public class Queue<T> {
	private Node<T> start = null;
	
	// enqueue	: Adds an element at the end of the queue
	// dequeue	: Removes the first element of the queue
	// last		: Returns the last element of the queue
	
	public Node<T> last() throws IllegalArgumentException {
		if (this.start == null) {
			throw new IllegalArgumentException("The queue is empty!");
		} else {
			Node<T> buffer = this.start;
			while (buffer.getNextNode() != null) {
				buffer = buffer.getNextNode();
			}
			return buffer;
		}
	}
	
	public void enqueue(T value) {
		Node<T> buffer = new Node<>(value);
		if (this.start == null) {
			this.start = buffer;
		} else {
			this.last().setNextNode(buffer);
		}
	}
	
	public Node<T> dequeue() {
		if (this.start == null) {
			return null;
		} else {
			Node<T> buffer = this.start;
			this.start = buffer.getNextNode();
			return buffer;
		}
	}
	
	@Override
	public String toString() {
		if (this.start == null) {
			return "[]";
		} else {
			StringBuilder builder = new StringBuilder("[");
			Node<T> buffer = this.start;
			builder.append(buffer.getValue());
			while (buffer.getNextNode() !=null) {
				builder.append(", ");
				buffer = buffer.getNextNode();
				builder.append(buffer.getValue());
			}
			builder.append("]");
			return builder.toString();
		}
	}
}