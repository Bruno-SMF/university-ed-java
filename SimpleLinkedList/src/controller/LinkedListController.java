package controller;

import model.LinkedList;

public class LinkedListController {
	public String testLinkedList() throws Exception {
		LinkedList list = new LinkedList();
		
		list.appendValue(1);
		list.appendValue(2);
		list.appendValue(3);
		
		list.removeNode(2);
		
		System.out.println("getLastNode().getValue(): " + list.getLastNode().getValue());
		System.out.println("getIndex(2): " + list.getIndex(2));
		System.out.println("getTotal(): " + list.getTotal()); 
		System.out.println("insertByIndex(1, 1) executed!");
		list.insertByIndex(1, 1);
		
		System.out.println("getTotal(): " + list.getTotal()); 
		System.out.println("getIndex(2): " + list.getIndex(2));
		
		return list.toString();
	}
}