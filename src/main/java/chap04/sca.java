package chap04;

import java.util.Arrays;
import java.util.Scanner;

public class sca {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		System.out.println(number);

		char [] arr = new char[number.length()];
		for(int i=0;i<number.length();i++) {
			arr[i]= number.charAt(i);
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(arr.length);
	}
}
