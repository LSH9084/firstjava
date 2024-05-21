package chap02;

public class SampleVarRef02 {

	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = "홍길동";
		System.out.println(str1+","+ str2);
		
		int i = 0;
		i = i+ 10;
		i = i+ 10;
		i = i+ 10;
		System.out.println(i);
		
		int num1 = 10;
		short num2 = (short) num1; 
		System.out.println(num1 == num2);
		float num3 = 10.6f;
		System.out.println(num3);
		int num4 = (short)num3;
		System.out.println(num4);
		
		int num5 = (int)(10.8);
		System.out.println(num5);
	}

}
