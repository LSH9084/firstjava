package chap03.prac04;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
//		int[] arrInt = {1,2,3};
//		int[] arrInt2 = new int[5];
//		System.arraycopy(arrInt,0,arrInt2,2,arrInt.length);
//		System.out.println(Arrays.toString(arrInt2));
//		
//		for(int i=0; i<arrInt2.length; i++) {
//			System.out.println(arrInt2[i]);
//		}
		
		int[] arrInt = {1,2,3};
		int [] arrInt2 = {};
		
		arrInt2 = Arrays.copyOf(arrInt, 5);
//		System.out.println(Arrays.toString(arrInt2));
		
		for(int number : arrInt2) {
			System.out.println(number);
		}
		
		String[] names = {"홍길동","이순신","김유신"};
		int[] scores = {90,80,100};
		
		int i = 0;
		for(String name : names) {
			System.out.println(name+"의 점수는"+scores[i]+"입니다.");
			i++;
		}
		
		
		
	}

}
