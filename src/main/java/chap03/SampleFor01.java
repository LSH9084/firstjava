package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class SampleFor01 {

	public static void main(String[] args) {
		
		
		String[] names = {"자바","파이썬","코틀린"};
		for (String name : names) {
			System.out.println(name);
		}
		
		String str = "Hello Java";
		char[] chr = str.toCharArray();
		for (char ch : chr) {
			System.out.println(ch);
		}
		System.out.println("switch()");
		int in = 10;
		switch(in) {
		case 1: 
		case 3:
		case 5:
		case 7:
		case 9:
			System.out.println("홀수");
			break;
		case 2:
		case 4:
		case 6:
		case 8:
		case 10:
			System.out.println("짝수");
			break;
		default:
			System.out.println("1부터 10까지의 수가 아님");
		}
		switch(in) {
		case 1,3,5,7,9 -> System.out.println("홀수 "+in);
		case 2,4,6,8,10 ->System.out.println("짝수 "+in);
		default ->System.out.println("1부터 10까지의 숫자가 아님");
		}
		
		
		int mon = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("계절을 판단 할 수 있게 월을 입력하세요:");
		mon = sc.nextInt();
		
//		String season = switch(mon) {
//		case 12,1,2 : yield "겨울";
//		case 3,4,5 : yield "봄";
//		case 6,7,8 : yield "여름";
//		case 9,10,11 : yield "가을";
//		default :yield "기후온난화";
//		}
		
		
		

	}

}
