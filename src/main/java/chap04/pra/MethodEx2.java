package chap04.pra;

public class MethodEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(pow(add(3,3))));

	}
	static int add(int x, int y) {
		return x+y;
	}
	static int pow(int x) {
		return x*x;
	}
	static int divide(int x) {
		return x/2;
	}

}
