package chap10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorCollection {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(3);
		System.out.println(list);
		list.forEach((x)->System.out.println(x));
		
		for (Integer i : list) {
			System.out.println(i);
		}
		
		Iterator<Integer> it = list.iterator();
		System.out.println("======");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("======");
		Iterator<Integer> it2 = list.iterator();
		it2.forEachRemaining(x->System.out.println(x));
		
		

	}

}
