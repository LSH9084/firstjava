package chap13.pra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamOptionalNoElem {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		long cnt = list.stream().count();
		System.out.println(cnt);
		
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		
		OptionalDouble avg = list.stream().mapToInt(Integer::intValue).average();
		if(avg.isPresent()) {
			System.out.println(avg);
		}
		
		int max = list.stream().mapToInt(Integer::intValue).max().orElse(0);
		System.out.println(max);
		
		int min = list.stream().mapToInt(Integer::intValue).min().orElse(-1);
		System.out.println(min);
		
		list.stream().mapToInt(Integer::intValue).findFirst().ifPresent(x->System.out.println(x));
		
		
		
	}
}
