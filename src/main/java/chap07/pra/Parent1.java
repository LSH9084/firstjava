package chap07.pra;

public class Parent1 {
	String name;
	
	void walk() {
		System.out.println("parents walk load");
	}
	
	void run() {
		System.out.println("parents run away");
	}
}

class Child1 extends Parent1 {
	String name;
	
	void run() {
		System.out.println("children run");
	}
	
	void eat() {
		System.out.println("children eat food");
	}
}
