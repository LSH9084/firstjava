package chap09;

import java.util.Scanner;

public class WrapperClass {
	public static void main(String[] args) {
		System.out.println("int최대값 :"+Integer.MAX_VALUE);
		System.out.println("int최대값 :"+Integer.MIN_VALUE);
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int number = Integer.parseInt(s);
		System.out.println(number+20+","+s+1);
		
	}
}
