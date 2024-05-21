package chap03;

import java.util.Scanner;

public class Test_Q03 {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int num1 = sc1.nextInt();
		int num2 = sc2.nextInt();

		if(num1>num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		int max = -9999;
		int min = 9999;
		for(int i=1; i<=num1; i++) {
			if(num1%i==0&&num2%i==0) {
				System.out.println("공약수는"+i);
				if(max < i) {
					max =i;
					
				}
				if(min>i&&i!=1) {
					min=i;
				}
			}
		}
		System.out.println("최대공약수는"+max);
		System.out.println("최소 공약수는"+min);
	}

}
