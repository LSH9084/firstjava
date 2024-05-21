package chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleArr01 {

	public static void main(String[] args) {
		int[] number = {10,20,30};
		int[] number1 = new int[3];
		System.out.println(number+","+number1);
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(number1));
		String[] str1 = new String[3];
		str1[0] = "홍길동"; str1[1] = "dd"; str1[2] = "홍길동길이";
		String[] str2 = {"자바","파이썬","코틀린"};
		System.out.println(Arrays.toString(str1));
		System.out.println(Arrays.toString(str2));
		System.out.println(str1.length+","+str2.length);
		
		String[] str3 = str2.clone();
		System.out.println(Arrays.toString(str3));
		System.out.println(str2 == str3);
		
		for (int i=0; i<str3.length; i++) {
			System.out.println(str3[i]);
		}
		
		String city = "서울:대전:대구:부산";
		String[] arrCity = city.split(":");
		System.out.println(Arrays.toString(arrCity));
		System.out.println("이스케이프문자 출력\"\"");
		
		int[] correct = {1,2,3,4,1,4,5,2,1,3};
		int[][] answer = {
				{1,1,3,4,1,4,5,2,1,3},
				{1,2,2,2,2,4,2,2,2,3},
				{1,2,3,3,3,3,3,2,3,3},
				{1,2,3,4,1,4,5,2,1,3},
				{1,4,4,4,1,4,5,2,1,3}
		};
		
		System.out.println("답안:"+Arrays.toString(correct));
		System.out.println("정답:"+Arrays.deepToString(answer));
		for(int i=0;i<5;i++) {
			System.out.println("정답:"+Arrays.toString(answer[i]));
			
		}
		int no =0;
		for ( int[] dap : answer ) {
			no++;
			if(Arrays.equals(correct, dap)) {
			System.out.println(no+":"+"만점"+Arrays.toString(dap));
		} else {
			System.out.println(no+":"+"만점아님"+Arrays.toString(dap));
		}		
		}	
		String[] han1 = new String[]{
				"라면","미역국","수제비","갈비탕","순대국"
		};
		String[] han2 = Arrays.copyOf(han1, han1.length-1);
		String[] han3 = Arrays.copyOf(han1, han1.length-2);
		String[] han4 = Arrays.copyOf(han1, han1.length-3);
		String[] han5 = Arrays.copyOf(han1, han1.length-4);
		String[] han6 = Arrays.copyOf(han1, han1.length-5);
		
		System.out.println(Arrays.toString(han2));
		System.out.println(Arrays.toString(han3));
		System.out.println(Arrays.toString(han4));
		System.out.println(Arrays.toString(han5));
		System.out.println(Arrays.toString(han6));
		System.out.println("첫 번째와 마지막 요소 제외한 복사");
		String[] han7 = Arrays.copyOfRange(han1,1,4);
		System.out.println(Arrays.toString(han7));
		
		Arrays.sort(han1,2,5);
		System.out.println(Arrays.toString(han1));
		
		//컬렉션 프레임워크에서 List자료형에 배열을 다른 메서드
		//List 객체 부모자식요소
		List<String> st = new ArrayList<String>();
		st.add("홍길순");
		st.add("동길이");
		System.out.println(st);
		
		List<String> st2 = Arrays.asList("동길이홍","길길동");
		System.out.println(st2);
		
		
		
		
	}
}

