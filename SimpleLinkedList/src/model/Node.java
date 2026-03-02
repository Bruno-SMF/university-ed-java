package model;

public class Node<T> {
	private T value;
	private Node<T> nextNode;
	
	public Node(T value) {
		this.nextNode = null;
		this.value = value;
	}
	
	public Node(T value, Node<T> nextNode) {
		this.nextNode = nextNode;
		this.value = value;
	}
	
	public T getValue() {return value;}
	public void setValue(T value) {this.value = value;}
	public Node<T> getNextNode() {return this.nextNode;}
	public void setNextNode(Node<T> nextNode) {this.nextNode = nextNode;}
}