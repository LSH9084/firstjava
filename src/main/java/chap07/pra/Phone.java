package chap07.pra;

public class Phone {
	String name;
	String color;
	String company;
	
	void call() {
		System.out.println("전화를 건다.");
		
	}
	void receive() {
		System.out.println("전화를 받다.");
	}
}

class SmartPhone extends Phone {
	public void installApp() {
		System.out.println("앱설치");
	}
}
