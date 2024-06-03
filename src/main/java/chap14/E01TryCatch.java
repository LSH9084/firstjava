package chap14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class E01TryCatch {
	public static void main(String[] args) {
		
		//예외 처리 ( Exception ), try-catch-finally, throw, throws, ...
		
		//에러가 발생시 비정상 종료하지 않고 정상적으로 종료하기위한 목적
		
		try {
			int i=5; 
			int [] a = new int[i];
			for(int j=0; j<=i; j++) {
				a[j] = j;
			}
			System.out.println(Arrays.toString(a));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류발생: "+ e.getMessage());	
		}
		
		System.out.println("정상 종료1");
		
		System.out.println("==========");
		
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류발생2: "+ e.getMessage());
		}
		System.out.println("정상종료2");
		
		System.out.println("중첩 Exception 처리");
		System.out.println("========");
		try {
//			int i=5; 
//			int [] a = new int[i];
//			for(int j=0; j<=i; j++) {
//				a[j] = j;
//			}
//			System.out.println(Arrays.toString(a));
//			
//			System.out.println(1/0);
			
			String msg = "";
			List<String> list = new ArrayList<String>();
			list.add("홍길동");
			list.add("동순이");
			
			list = Collections.unmodifiableList(list);
			list.add("강감찬");
			
		} catch (ArrayIndexOutOfBoundsException e1) {
			// TODO: handle exception
			System.out.println(e1.getMessage()+"====(1)");
		} catch (ArithmeticException e2) {
			// TODO: handle exception
			System.out.println(e2.getMessage()+"=====(2)");
		} catch (Exception e3) {
			// TODO: handle exception
			System.out.println(e3.getMessage()+"======(3)");   //캐치문을 중첩할 수록 뒤에 catch에는 앞의 것보다 더 상위클래스를 써야한다.
		} finally {
			System.out.println("==="); //예외 처리와 관계없이 무조건 수행할 내용
		}
		
		System.out.println("정상종료3");
		
		
		
		
		
		
	}
}
