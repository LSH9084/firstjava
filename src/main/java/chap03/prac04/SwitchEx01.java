package chap03.prac04;

import java.util.Scanner;

public class SwitchEx01 {
	 		public static void main(String[] args) {
				System.out.println("점수를 입력하세요");
				Scanner sc = new Scanner(System.in);
				int score = sc.nextInt();
				String grade = "";
				switch (score/10) {
				case 8,9 -> grade = "A";
				case 6,7 -> grade = "B";
				case 4,5 -> grade = "C";
				default -> grade = "퇴학";
				}
				System.out.println(grade);
			}
}
