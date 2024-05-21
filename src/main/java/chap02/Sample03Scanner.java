package chap02;

import java.util.Random;
import java.util.Scanner;

public class Sample03Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("입력할 값:");
//		String in = sc.nextLine();
//		System.out.println("입력한 값 : "+in);
//		
//		int num1 = 0;
//		System.out.print("숫자:");
//		num1 = sc.nextInt();
//		System.out.println("숫자:"+num1+","+(num1*2));
//		float num2 = sc.nextFloat();
//		System.out.println("숫자:"+num2+","+(num2*2));
//		num1 = sc.nextInt();
//		System.out.println("숫자:"+num1+","+(num1*2));
		
//		String str = "";
//		System.out.print("문자열:");
//		str = sc.nextLine();
//		System.out.println("문자열:"+str);
//		char[] chr;
//		System.out.print("문자배열:");
//		chr = sc.next().toCharArray();
//		System.out.println("문자배열:"+chr[0]);
		
		final float PI = 3.14159f; //final이 달리면 상수화된 변수 ,, 읽기전용 const 단 대괄호 안에서만 작용
		System.out.println(PI);
		
		Random rnd = new Random();
				int num_rnd = rnd.nextInt(30)+1;
				System.out.println(num_rnd);
		
		
	}

}
