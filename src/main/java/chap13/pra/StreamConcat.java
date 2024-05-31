package chap13.pra;

import java.util.stream.Stream;

public class StreamConcat {
	public static void main(String[] args) {
		
		Stream<String> stm1 = Stream.of("홍길동","김유신","이순신","유관순");
		
		Stream<Integer> stm2 = Stream.of(1,2,3,4,5,6,7,8,9,10);
		
		Stream<Object> concat = Stream.concat(stm1,stm2);
		concat.forEach(System.out::println);
		
	}
}
