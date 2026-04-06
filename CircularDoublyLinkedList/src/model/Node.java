package model;

public class Node<T> {
	private T value;
	private Node<T> nextNode;
	private Node<T> previousNode;
	
	public Node(T value) {
		this.value = value;
		this.previousNode = null;
		this.nextNode = null;
	}
	
	public T getValue() {return this.value;}
	public Node<T> getNextNode() {return this.nextNode;}
	public Node<T> getPreviousNode() {return this.previousNode;}
	public void setValue(T value) {this.value = value;}
	public void setNextNode(Node<T> nextNode) {this.nextNode = nextNode;}
	public void setPreviousNode(Node<T> previousNode) {this.previousNode = previousNode;}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
}