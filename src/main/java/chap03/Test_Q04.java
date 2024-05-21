package chap03;

import java.util.Scanner;

public class Test_Q04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(num);
		int count = 0;
		for(int i=2;i<num+1;i++) {
			if(num%i==0) {
				count++;
				
			}
		}
		if(count==1) {
			System.out.println(num+"는 소수이다.");
		} else System.out.println("소수가아니다.");

	}

}
