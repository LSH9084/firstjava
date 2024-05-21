package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class Test_Q02 {
		
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("자연수를 입력해주세요 : ");
		String num1 = sc.next();
		System.out.printf(num1);
		int[] num2 = new int[num1.length()];
		for(int i=0; i<num1.length();i++) {
			num2[i] = num1.charAt(i)-'0';
		}
		System.out.println(Arrays.toString(num2));
		int sum =0;
		for(int j=0; j<num2.length;j++) {
			System.out.println(num2[j]);
			sum += num2[j];
		}
		System.out.println("모든 자리수의 합은:"+sum);
		
	}

}
