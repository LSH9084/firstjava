package chap13.pra;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamFlatMap {
	public static void main(String[] args) {
		
		List<String> list1 = Arrays.asList(
				"동해물과","백두산이","마르고","닳도록"
				);
		list1.stream().flatMap(x->Arrays.stream(x.split(" "))).forEach(System.out::print);
		System.out.println();
		
		List<String> list2 = Arrays.asList(
				"1.1,2.2,3.3","4.4,5.5,6.6"
				);
		
		DoubleStream stm1 = list2.stream().flatMapToDouble(x -> {
			String [] strArr = x.split(",");
			double [] intArr = new double[strArr.length];
			for(int i=0; i<strArr.length;i++) {
				intArr[i]	 = Double.parseDouble(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		});
		stm1.forEach(x -> System.out.println(x));
		
		
		System.out.println();
		List<String> list3 = Arrays.asList("1,2,3","4,5,6");
		IntStream stm2 = list3.stream().flatMapToInt(x->{
			String [] str1 = x.split(",");
			int [] int2 = new int[str1.length];
			for(int i =0 ; i<str1.length; i++) {
				int2[i] = Integer.parseInt(str1[i].trim());
			}
			return Arrays.stream(int2);
		});
		stm2.forEach(System.out::println);
		
		List<String> list4 = Arrays.asList(
				"1,2,3","4"
				);
		
	}
			
}
