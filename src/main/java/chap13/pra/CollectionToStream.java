package chap13.pra;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectionToStream {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("a","b","c","d","e");
		
		Stream<String> stm1 = list.stream();
		stm1.forEach(System.out::println);
	}
}
