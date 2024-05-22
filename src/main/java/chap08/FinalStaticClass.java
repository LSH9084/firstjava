package chap08;

public class FinalStaticClass {

	public static void main(String[] args) {
		DynamicNumber n1 = new DynamicNumber();
		n1.increaseNum();
		System.out.println(n1.getNumCounter());
		n1.increaseNum();
		System.out.println(n1.getNumCounter());
		n1.increaseNum();
		System.out.println(n1.getNumCounter());
		
		StaticNumber n2 = new StaticNumber();
		n2.increaseNum();
		System.out.println(n2.getNumCounter());
		n2.increaseNum();
		System.out.println(n2.getNumCounter());
		
		
		StaticNumber s1 = new StaticNumber();
		StaticNumber s2 = new StaticNumber();
		
		s1.increaseNum();
		System.out.println(s1.getNumCounter());
		s2.increaseNum();
		System.out.println(s2.getNumCounter());
		
		StaticNumber.num2 = 100;
		System.out.println(StaticNumber.getNumCounter());
	}

}

class DynamicNumber{
	private int num = 0;
	
	public int getNumCounter() {
		return num;
	}
	
	public void increaseNum() {
		num++;
	}
	
}
class StaticNumber{
	static int num2 = 0;
	public static int getNumCounter() {
		return num2;
	}
	
	public static void increaseNum() {
		num2++;
	}
}