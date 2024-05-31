package chap13.pra;

import java.util.function.Function;
import java.util.stream.Stream;

public class StreamByBuilder {
	public static void main(String[] args) {
		
		Stream stm1 = Stream.builder()
							.add("무궁화")
							.add("삼천리")
							.add("화려강산")
							.add("대한사람")
							.build();
		
		stm1.forEach(System.out::println);
		
		Stream stm2 = Stream.generate(()->"애국가").limit(10);
		stm2.forEach(System.out::println);
	}
}
