package chap13.pra;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class E01IteratorEx {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList(
				new String[] {"홍길동","김유신","이순신","유관순"}
				);
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		list.stream().forEach(System.out::println);
				
	}
}
