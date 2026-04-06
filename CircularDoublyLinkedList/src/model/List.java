package model;

import model.Node;
import java.lang.Exception;

public class List<T> {
	private Node<T> lastNode = null;
	
	// Methods
	//
	// append	: Adds a new element after the last added Node
	// getLast	: Returns the last added Node
	// remove	: Removes a specific Node or the last added Node
	// totoal	: Returns the number of Nodes
	
	public void append(T value) {
		Node<T> buffer = new Node<>(value);
		if (this.lastNode == null) {
			this.lastNode = buffer;
			this.lastNode.setPreviousNode(lastNode);
			this.lastNode.setNextNode(lastNode);
		} else {
			Node<T> bufferLastNode = this.lastNode;
			Node<T> bufferNextNode = this.lastNode.getNextNode();
			bufferLastNode.setNextNode(buffer);
			bufferNextNode.setPreviousNode(buffer);
			buffer.setNextNode(bufferNextNode);
			buffer.setPreviousNode(bufferLastNode);
			lastNode = buffer;
		}
	}
	
	public Node<T> getLast() throws IllegalArgumentException {
		if (this.lastNode == null) {
			throw new IllegalArgumentException("The list is empty!");
		} else {
			return this.lastNode;
		}
	}
	
	public void remove(Node<T> removeNode) {
		Node<T> previousNode = removeNode.getPreviousNode();
		Node<T> nextNode = removeNode.getNextNode();
		if (this.lastNode == removeNode && nextNode == removeNode && previousNode == removeNode) {
			this.lastNode = null;
		} else {
			previousNode.setNextNode(nextNode);
			nextNode.setPreviousNode(previousNode);
			if (this.lastNode == removeNode) {
				this.lastNode = previousNode;
			}
		}
	}
	
	public void remove() throws IllegalArgumentException {
		if (this.lastNode == null) {
			throw new IllegalArgumentException("The list is empty!");
		} else {
			remove(this.lastNode);
		}
	}
	
	public int total() {
		if (this.lastNode == null) {
			return 0;
		} else {
			int totalNodes = 1;
			Node<T> bufferNext = lastNode.getNextNode();
			while (bufferNext != this.lastNode) {
				bufferNext = bufferNext.getNextNode();
				totalNodes++;
			}
			return totalNodes;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		if (this.lastNode != null) {
			Node<T> buffer = this.lastNode;
			do {
				builder.append(buffer.getValue());
				if (buffer.getNextNode() != this.lastNode) {
					builder.append(", ");
				}
				buffer = buffer.getNextNode();
			} while (buffer != this.lastNode);
		}
		builder.append("]");
		return builder.toString();
	}
}