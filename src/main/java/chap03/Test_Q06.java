package chap03;

import java.util.Scanner;

public class Test_Q06 {

	public static void main(String[] args) {
//		int a = 31;
//		System.out.printf("%32s = %d",Integer.toBinaryString(31),31);
		int[] dap = {1,1,0,0,1};
		System.out.print("답 입력");
		Scanner sc = new Scanner(System.in);
		String inn = sc.nextLine();
		
		System.out.print("정답>\n");
		for(int n : dap) {
			System.out.println(n);
		}
		System.out.println("결과>");
		int tagetLoc = 0;
		for(char c : inn.toCharArray()) {
			System.out.print(((c ^ (dap[tagetLoc]))== 1 )? "0":"X");
			tagetLoc++;
		}
		
		
	}
	
	

}
