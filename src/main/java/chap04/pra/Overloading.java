package chap04.pra;

public class Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		operator m = new operator()	;
		System.out.println(m.multiply(4.5, 3));
		System.out.println(m.multiply(2.5, 3.5));
		

	}

}

class operator {
	int multiply(int x, int y) {
		System.out.println("int int");
		return x*y;
	}
	double multiply(double x, double y) {
		return x*y;
	}
	double multiply(int x, double y) {
		return x*y;
	}
	double multiply(double x , int y) {
		return x*y;
	}
}