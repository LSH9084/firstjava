package chap09.Interface;

public class InstanceofEx {
	public static void main(String[] args) {
		A a1 = new AAA();
		
		AA a2 = new AAA();
		
		AAA a3 = new AAA();
		
		A b = new ABB();
		AB b2 = new ABB();
		ABB b3 = new ABB();
		
		System.out.println((a1 instanceof A));
		System.out.println(a2 instanceof A);
		System.out.println(a3 instanceof A);
		System.out.println(a3 instanceof AB);
		
	}
}
