package chap13.E02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q03Stream {
	public static void main(String[] args) {
		IntStream int1 = IntStream.range(1, 11);
		Map<Boolean, List<Integer>> int2 = int1.boxed().collect(Collectors.groupingBy(x-> x%2==0));
		System.out.println(int2.get(true));
		System.out.println(int2.get(false));
		
		 List<Integer> int3 = Arrays.asList(-1, 3, -5, 7, 10, -2, 4, -6);
		 
		 Map<Boolean, List<Integer>> int4 = int3.stream().collect(Collectors.groupingBy(x-> x>0));
		 var int5 = int4.get(true).stream().reduce(Integer::sum);
		 System.out.println(int5.get());
		 var int6 = int4.get(false).stream().reduce(Integer::sum);
		 System.out.println(int6.get());
		 
		 List<String> words = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
		 
		 Map<Boolean, List<String>> words2 = words.stream().collect(Collectors.partitioningBy(x-> x.length()%2==0));
		 System.out.println("짝수길이의 문자열: "+words2.get(true));
		 System.out.println("홀수길이의 문자열: "+words2.get(false));
		 
		 
		 
		 
		 
		
		
	}
}
