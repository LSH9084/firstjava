package chap13.pra;

import java.util.Arrays;
import java.util.List;

public class FilterStream {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList(
				"홍길동","김유신","홍길동","이순신","홍길동","유관순"
				);
		
		list.stream().distinct().forEach(System.out::println);
		System.out.println();
		
		list.stream().filter(n-> n.startsWith("홍")).forEach(System.out::println);
		System.out.println();
		list.stream().distinct().filter(x-> x.startsWith("홍")).forEach(System.out::println);
				
	}
}
