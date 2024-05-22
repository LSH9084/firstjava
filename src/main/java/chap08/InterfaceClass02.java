package chap08;

public class InterfaceClass02 {

	public static void main(String[] args) {
		Person1 p1 = new Person1();
		Person2 p2 = new Person2();
		Person3 p3 = new Person3();
		
		p1.study();
		p3.study();
		p3.teach();
	}

}

interface Students {
	void study();
}

interface Teacher{
	void teach();
}

class Person1 implements Students{

	@Override
	public void study() {
		System.out.println("Person1 공부한다.");
	}
	
}

class Person2 implements Teacher{

	@Override
	public void teach() {
		System.out.println("Person2 가르친다.");
	}
	
}

class Person3 implements Students, Teacher{

	@Override
	public void teach() {
		System.out.println("Person3이 가르친다.");
	}

	@Override
	public void study() {
		System.out.println("Person3이 공부한다.");
	}
	
}