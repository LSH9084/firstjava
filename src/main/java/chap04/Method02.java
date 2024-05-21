package chap04;

public class Method02 {

	public static void main(String[] args) {
		hello();
		hello("kane");
		hello(13);
		System.out.println(sum(20,30,10));
		System.out.println(sum2(10));
		
	}
	public static void hello() {
		System.out.println("hello");
	}
	public static void hello(String name) {
		System.out.println("hello "+ name);
	}
	public static void hello(int v) {
		System.out.println("hello "+v);
	}
	public static int sum (int... num1) {
		int tot = 0;
		for(int i : num1) {
			tot += i;
		}
		return tot;
	}
	public static int sum2 (int a) {
		if(a == 1)
			return 1;
		else 
			return a+sum2(a-1);
	}
}
