package Chap11.E02;

public class E01FunInterface {
	
	public static void main(String[] args) {
		Sample01Function f = () ->{
			System.out.println("함수형 인터페이스 내용입니다.");
		};
		f.test();
		Sample02Function f2 = (t) ->{
				String result = "";
				for(int i =0; i<t; i++) {
					result += "만세\n";
				}
				return result;
		};
		System.out.println(f2.test(3));
		
	}
}

interface Sample01Function {
	public void test();
}

interface A {
	public void test2();
}

class AA implements A{
	public void test2() {
		
	}
}

interface Sample02Function {
	public String test(int times);
}