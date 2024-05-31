package chap13.pra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamOrder {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList(
				"홍길동","김유신","이순신","유관순"
				);
		
		
		list.stream().sorted().forEach(System.out::println);
		
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
}
