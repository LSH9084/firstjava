package chap13.E01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class E03StramCollection {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		var list2 = new HashSet<Integer>();
		
		list1.add("dog");list1.add("dog");
		list1.add("cat");list1.add("cat");
		
		list2.add(3);list2.add(3);
		list2.add(5); list2.add(5);
		list2.add(6);list2.add(6);
		
		Stream<String> stm1 = list1.stream();
		Stream<Integer> stm2 = list2.stream();
		stm1.distinct().forEach(System.out::println); //distinct()는 중복제거함수
		stm2.forEach(v->System.out.println(v));
		
		String[] arr1 = null;
		//Stream<String> stm3 = Stream.of(arr1); 이건 에러걸림
		Stream<Object> stm4 = Stream.of(arr1==null ? Stream.empty():arr1);
		stm4.forEach(v->System.out.println(v));
		
		
		
	}
}
