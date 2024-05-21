package chap03.prac04;

import java.util.Arrays;

public class ForEx00 {

	public static void main(String[] args) {
		int [] num = new int[100];
		for(int i=0; i<num.length; i++) {
			num[i] = i+1;
		}
		System.out.println(Arrays.toString(num));

	}

}
