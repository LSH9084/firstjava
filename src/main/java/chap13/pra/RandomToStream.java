package chap13.pra;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RandomToStream {
	public static void main(String[] args) {
		
		IntStream stm1 = new Random().ints(3);
		stm1.forEach(System.out::println);
		
		stm1 = new Random().ints(10,0,3);
		stm1.forEach(System.out::println);
		
		LongStream stm2 = new Random().longs(3,0,10);
		stm2.forEach(System.out::println);
		
		DoubleStream stm3 = new Random().doubles(3,1,2);
		stm3.forEach(System.out::println);
	}
}
