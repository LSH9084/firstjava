package chap03;

import java.util.Scanner;

public class sampleBitOper01 {

	public static void main(String[] args) {
		int a = 429496;
		int b = 1584990;
		
//		System.out.println("비트연산자<<:"+(a<<2));
//		System.out.println("비트연산자>>:"+(a>>4));
//		System.out.println();
		System.out.println("비트연산 &:"+(a&b));
		System.out.println("비트연산 |:"+(a|b));
		System.out.println("비트연산 ~:"+(~a));
		System.out.println("비트연산 ^:"+(a^b));
		System.out.println("2진수 표현법");
//		System.out.printf("[%32s] [%d]",Integer.toBinaryString(a),a);
		System.out.printf("[%32s] [%d]\n",Integer.toBinaryString(~b),~b);
		
		System.out.println("3항연산자");
		int number;
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("숫자:");
//		number = sc.nextInt();
//		
//		String result = (number%2==0) ? "짝수":"홀수";
//		System.out.println(result);
		
		int num1 = 10;
		System.out.println(num1++);
		System.out.println(num1);
		
	}

}
