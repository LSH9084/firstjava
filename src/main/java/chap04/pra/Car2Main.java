package chap04.pra;

public class Car2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car2 c1 = new Car2();
		Car2 c2 = new Car2("중형");
		Car2 c3 = new Car2("형대","대형");
		Car2 c4 = new Car2("블랙","기아","화물");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}

}
