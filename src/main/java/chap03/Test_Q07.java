package chap03;

import java.util.Scanner;

public class Test_Q07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단어를 입력: ");
		String word = sc.next();
		System.out.println(word);
		String pass1 = ""; //암호화
		String pass2 = ""; //복호화
		
		for(char c : word.toCharArray()) {
			pass1 += ""+(char)(c+3);
		}
		for(char c : pass1.toCharArray()) {
			pass2 += ""+(char)(c-3);
		}
		System.out.printf("암호화된 단어 : %s \n복호화된 단어 : %s",pass1,pass2);

	}

}
