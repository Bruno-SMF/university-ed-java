package controller;

import model.List;

public class ListController {
	public String testList() throws IllegalArgumentException {
		List list = new List();
		
		list.append(1);
		list.append(2);
		list.append(3);
		
		list.remove(list.getLast().getNextNode());
		
		list.append(4);
		list.append(5);
		list.append(6);
		
		list.remove(list.getLast().getPreviousNode());
		
		return list.toString();
	}
}