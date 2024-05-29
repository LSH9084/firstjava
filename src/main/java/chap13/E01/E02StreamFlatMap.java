package chap13.E01;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E02StreamFlatMap {
	static int sum = 0;
	
	public static void main(String[] args) {
		
		String[] str1 = {
			"홍길동","동길이","동순이"	
		};
		String [] str2 = {
				"김길동","이순신","정찬영"
		};
		System.out.println(Arrays.toString(str1));
		System.out.println("==stream통에서 개별 배열을 꺼내는법==");
		Stream<String[]> stm1 = Stream.of(str1,str2);
//		stm1.forEach(v->System.out.println(Arrays.toString(v)));
//		stm1.forEach(v->System.out.println(Arrays.toString(v))); stream()이기 때문에 마찬가지로 한번만 뽑아쓸수 있다 
		
		System.out.println("==stream.flatMap()==");
		Stream<String> stm2 = stm1.flatMap(Arrays::stream);
		stm2.forEach(v->System.out.println(v));
		
		IntStream stmNum1 = IntStream.range(0, 10);
		stmNum1.forEach(v->System.out.print(v+" | "));
		System.out.println();
		IntStream.range(0, 5).forEach(System.out::print);
		System.out.println();
		IntStream.rangeClosed(0, 5).forEach(v->System.out.print(v));
		System.out.println();
//		int sum = 0;
		//스트림 내에서 외부에 있는 기억장소를 사용시 : 멤버변수를 적용
		IntStream.rangeClosed(1, 10).forEach(v-> sum += v);
		System.out.println(sum);
		
		
		
	}
}
