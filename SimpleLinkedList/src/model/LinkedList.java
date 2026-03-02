package model;

import java.lang.Exception;
import model.Node;

public class LinkedList<T> {
	private Node<T> start = null;
	
	// appendValue		Appends a new node with a given value
	// getLastNode		Returns the last node from the list
	// getIndex			Searches for a specific value and returns the node index if found
	// insertByIndex	Inserts a value at a specific node index
	// insertNextNode	Inserts a new node immediately after a given node
	// getNodeByIndex	Returns a node given a specific index
	// removeNode		Removes a node at a specific index
	// getTotal			Returns the total number of nodes
	
	public Node<T> getLastNode() throws IllegalArgumentException {
		if (this.start == null) {
			throw new IllegalArgumentException("The list is empty!");
		} else {
			Node<T> buffer = this.start;
			while (buffer.getNextNode() != null) {
				buffer = buffer.getNextNode();
			}
			return buffer;
		}
	}
	
	public void appendValue(T value) {
		Node<T> buffer = new Node<>(value);
		
		if (this.start == null) {
			this.start = buffer;
		} else {
			this.getLastNode().setNextNode(buffer);
		}
	}
	
	public int getIndex(T value) throws IllegalArgumentException {
		if (this.start == null) {
			throw new IllegalArgumentException("The list is empty!");
		} else {
			int i = 0;
			Node<T> buffer = this.start;
			do {
				if (buffer.getValue() == value) {
					return i;
				} else {
					buffer = buffer.getNextNode();
					i++;
				}
			} while (buffer != null);
			throw new IllegalArgumentException("Value not found!");
		}
	}
	
	public void insertByIndex(T value, int index) throws IllegalArgumentException {
		if (index == 0) {
			Node<T> buffer = new Node<>(value);
			if (this.start == null) {
				this.start = buffer;
			} else {
				// THIS MIGHT NOT WORK, TRY AND FIX IF NEEDED
				buffer.setNextNode(this.start);
				this.start = buffer;				
			}
		} else {
			insertNextNode(value, getNodeByIndex(index - 1));
		}
	}
	
	public void insertNextNode(T value, Node<T> node) {
		Node<T> buffer = new Node<>(value);
		buffer.setNextNode(node.getNextNode());
		node.setNextNode(buffer);
	}
	
	public Node<T> getNodeByIndex(int index) throws IllegalArgumentException {
		if (this.start == null) {
			throw new IllegalArgumentException("The list is empty!");
		} else {
			Node<T> buffer = this.start;
			int i = 0;
			while (buffer.getNextNode() != null && i < index) {
				buffer = buffer.getNextNode();
				i++;
			}
			if (i == index) {
				return buffer;
			} else {
				throw new IllegalArgumentException("Invalid index!");
			}
		}
	}
	
	public void removeNode(int index) throws IllegalArgumentException {
		if (this.start == null) {
			throw new IllegalArgumentException("The list is empty!");
		} else if (index == 0) {
			if (this.start.getNextNode() == null) {
				this.start = null;
			} else {
				this.start = this.start.getNextNode();
			}
		} else {
			Node<T> buffer = getNodeByIndex(index - 1);
			buffer.setNextNode(buffer.getNextNode().getNextNode());
		}		
	}
	
	public int getTotal() {
		if (this.start == null) {
			return 0;
		} else {
			int count = 1;
			Node<T> buffer = this.start;
			while (buffer.getNextNode() != null) {
				count++;
				buffer = buffer.getNextNode();
			}
			return count;
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
			while (buffer.getNextNode() != null) {
				builder.append(", ");
				buffer = buffer.getNextNode();
				builder.append(buffer.getValue());
			}
			builder.append("]");
			return builder.toString();
		}
	}
}