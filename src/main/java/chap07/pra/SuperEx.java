package chap07.pra;

public class SuperEx {
	public static void main(String[] args) {
		Child chil = new Child();
		chil.print();
	}
}


class Parent {
	
	int number = 3;
	
	Parent(){
		System.out.println("create parent class ");
	}
}

class Child extends Parent {
	
	int number =2;
	
	Child(){
		System.out.println("create child class");
	}
	
	void print() {
		int number = 1;
		System.out.println(number);
		System.out.println(this.number);
		System.out.println(super.number);
	}
}