package chap10;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//import java.util.List;
import java.util.Stack;

public class StackCollection {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.add("dd");
		stack.push("adsd1");
		stack.push("adsd2");
		stack.push("adsd3");
		
		
		System.out.println(stack);
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		stack.pop();
		stack.pop();
		System.out.println(stack+"====");
		stack.add(2,"ddd");
		stack.remove(1);
		stack.size();
		System.out.println(stack);
		while(!stack.isEmpty()) {
			stack.pop();
			System.out.println(stack);
		}
		while(stack.size()<(int)3) {
			stack.push("111");
			System.out.println(stack);
		}
		
		Queue<String> q = new LinkedList<String>();
		q.add("asd1");
		System.out.println(q);
		q.add("asd2");
		q.add("asd3");
		System.out.println(q);
		q.poll();
		System.out.println(q);
		q.poll();
		System.out.println(q);
		
		
	}
}
