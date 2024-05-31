package chap13.pra;

import java.util.Arrays;
import java.util.stream.Stream;

public class E02ArrayToStream {
	public static void main(String[] args) {
		
		String [] arr = new String[] {"a","b","c","d","e","f"};
		
		Stream<String> stm1 = Arrays.stream(arr);
		stm1.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		Stream<String> stm2 = Arrays.stream(arr,2,5);
		stm2.forEach(x-> System.out.print(x+" "));
		
	}
}
