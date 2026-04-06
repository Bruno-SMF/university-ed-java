package controller;

import model.Stack;

public class StackController {
	public String testStack() throws Exception {
		Stack stack = new Stack();
		
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.push(3);
		
		return stack.toString();
	}
}