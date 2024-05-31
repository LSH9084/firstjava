package chap13.pra;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamEx {
	public static void main(String[] args) {
		
		int [] arr = {1,2,3,4,5};
		IntStream stm1 = Arrays.stream(arr);
		stm1.forEach(System.out::println);
		
		IntStream stm2 = IntStream.of(arr);
		stm2.forEach(System.out::println);
		
		IntStream stm3 = IntStream.range(1, 6);
		stm3.forEach(System.out::println);
		
		IntStream stm4 = IntStream.rangeClosed(1, 5);
		stm4.forEach(System.out::println);
	}
}
