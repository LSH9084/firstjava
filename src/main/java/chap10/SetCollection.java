package chap10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetCollection {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		set.add("5");set.add("2");set.add("3");set.add("4");set.add("5");set.add("6");
		set.add("1");set.add("1");set.add("1");set.add("1");set.add("5");
		System.out.println(set);
		
		System.out.println("=======");
		
		List<String> list = new ArrayList<String>();
		list.add("dog");
		list.add("dog");
		list.add("cat");list.add("cat");
		list.add("lion");
		System.out.println(list);
		
		set.addAll(list);
		System.out.println(set+"=====");
		List<String> list2 = new ArrayList<String>();
		list2.addAll(set);
		System.out.println(list2);
		
		
		
	}
}
 