package chap02;

public class SampleVar01 {
	public static void main(String[] args) {
		char a = 'b';
		System.out.println("a = "+a);
		System.out.println("encoding = "+(int)a);
		System.out.println("연산결과 = "+(char)(10+(int)a+61));
		System.out.println("decoding = "+(char)108);
		
		byte a1 = 127 , a2 = -128;
//		System.out.println(a1);
		System.out.printf("byte: min=%d, max=%d\n",a1,a2);
		int c1 = 1000 ;
		long c2 = 1000L;
		System.out.println(c1+c2);
		float f1 = 10.2f;
		double f2 = 10.2;
		System.out.println(20.1+f1);
		System.out.println(20.1+f2);
		System.out.printf("float: %.10f \ndouble: %.10f \n",20.1+f1,20.1+f2);
		System.out.printf("10진:%d, 8진:%o, 16진:%x \n",10,10,10);
		System.out.printf("지수: %e \n%e\n%f \n",1.e3, 1.e-3,1.0e-3);
		
		String str1 = "hi";
		System.out.println("str1 : "+str1);
		System.out.printf("%s %s %s\n",str1,str1.toUpperCase(),"haha");
		
	}

}
