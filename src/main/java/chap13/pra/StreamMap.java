package chap13.pra;

import java.util.Arrays;
import java.util.List;

public class StreamMap {
	public static void main(String[] args) {
		
		
		List<String> list = Arrays.asList(
				"동해물과","백두산이","마르고 닳도록"
				);
		
		list.stream().mapToInt(x->x.length()).forEach(System.out::println);
		
		list.stream().mapToInt(String::length).forEach(System.out::println);
	}
}
