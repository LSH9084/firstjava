package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class Test_Q05 {

	public static void main(String[] args) {
		int number;
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요:");
		
		number = sc.nextInt();
		System.out.println(number);
		int[] arrNum = new int[number];
		for(int i =0; i<number; i++) {
			arrNum[i] = i+1;
			
		}
		System.out.println(Arrays.toString(arrNum));
		
		for(int i=0; i<arrNum.length; i++) {
			System.out.printf("arrNum[%d]=%d \n"  ,i, arrNum[i]);
		}
		int idx = 0;
		for(int num : arrNum) {
			System.out.printf("arrNum[%d]=%d \n",num,arrNum[idx]);
			idx++;		
		}
		System.out.println("--Arrays stream()");
		Arrays.stream(arrNum).forEach((v)->{
			System.out.println(v);
		});
		Arrays.stream(arrNum).forEach(System.out::println);
		
		int[] num = new int[3];
		
		
		
	}
		

}
