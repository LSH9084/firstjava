package chap13.E02;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Q02Collect {
	public static void main(String[] args) {
		
		IntStream int1 = IntStream.range(2, 10);
		int1.forEach(x-> {
			System.out.println("=="+x+"단==");
			IntStream int2 = IntStream.range(2, 10);
			int2.forEach(y->{
				
				System.out.println(x*y);
			});
		});
	System.out.println("==2번 문제==");
	int firstSave = 500000;
	Stream<Integer> int3 = Stream.of(20000,5000,10000,200000,100000,50000,10000,2000,3500,50000);
//		int3.forEach(System.out::println);
	Optional<Integer> int4 = int3.reduce(Integer::sum);
//		int4.ifPresent(System.out::println);
	Optional<Integer> int5 = Optional.of(int4.stream().reduce(firstSave,(x,y)-> x-y));
	System.out.println(int5.get());
		
	System.out.println("==3번 문제==");
	
	IntStream.range(2, 101).filter(x-> {
			int i = IntStream.range(2, x-1).map(y->(x%y)==0 ? 1:0).reduce(0, Integer::sum);
			return i <2;
	}).forEach(x->System.out.println(x+"|"));
	
	List<String> list1 = Arrays.asList("sample01","sample02","sample03");
	System.out.println(list1);
	List<String> list2 = list1.stream().map(x-> x+".java").collect(toList());
	System.out.println(list2);
	
	System.out.println("==5번 문제==");
	
	Stream.generate(Math::random).map(x-> (x*44)+1).map(Math::round).distinct().limit(6).sorted().forEach(System.out::println);
	


		
		
		
	}
	
	
	
}
