package chap13.pra;

import java.util.Arrays;

public class StreamOther {
	public static void main(String[] args) {
		
		
		int int1 [] = {10,20,30,40,50,60};
		
		Arrays.stream(int1).asDoubleStream().forEach(System.out::println);
		
		Arrays.stream(int1).boxed().forEach(x->System.out.println(x.getClass()));
	}
}
