package chap13.E02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E05CollectMethod06 {
	public static void main(String[] args) {
		String[] str1 = {"홍길동","동길이","동순이"};
		String[] str2 = {"김길동","이순신","강감찬"}; 
		
		Stream<String[]> strm1 = Stream.of(str1,str2);
//		System.out.println(strm1);
		
		strm1.forEach(x->{
			System.out.println(Arrays.toString(x));
			for(String s : x) {
				System.out.println(s);
			}
		});
		Stream<String[]> strm2 = Stream.of(str1,str2);
		
		List<String> list1 = strm2.flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
		System.out.println(list1);
		
		list1.forEach(v-> System.out.println(v));
		
		
	}
}
