package chap04;

public class Method01 {
	
	public static void main(String[] args) {
		Method01 m = new Method01();
		m.hello();
		m.sum(12, 13);
		m.sum2(100, 200);
		int result = m.sum2(100,200);
		System.out.println(result);
		hello2();
	}
	public void hello() {
		System.out.println("hello");
	}
	public void sum(int num1, int num2) {
		System.out.println(num1+","+num2);
		System.out.println(num1+num2);
	}
	public int sum2(int a ,int b) {
		return a+b;
	}
	
	public static void hello2() {
		System.out.println("hello java!!");
	}
	
}
