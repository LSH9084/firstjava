package chap13.pra;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class StreamOptional {
	public static void main(String[] args) {
		
		int[] arr = new int[100];
		
		for(int i=0; i<100; i++) {
			arr[i]= i+1;
		}
		System.out.println(Arrays.toString(arr));
		
		long cnt = Arrays.stream(arr).count();
		System.out.println(cnt);
		
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);
		
		OptionalInt first = Arrays.stream(arr).findFirst();
		System.out.println(first.getAsInt());
		
		OptionalInt max = Arrays.stream(arr).max();
		System.out.println(max.getAsInt());
		
		OptionalInt min = Arrays.stream(arr).min();
		System.out.println(min.getAsInt());
		
		OptionalDouble avg = Arrays.stream(arr).average();
		System.out.println(avg.getAsDouble());
		
	}
}
