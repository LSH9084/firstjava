package chap10.pra;

import java.util.ArrayList;
import java.util.List;

public class ListEx {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(1);
		list.add(1);
		list.add(1);
		
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(1);
		System.out.println(list);
		list.forEach(x->System.out.println(x));
		System.out.println("=====");
		for ( var s : list) {
			System.out.println(s);
		}
		
		
	}
}
