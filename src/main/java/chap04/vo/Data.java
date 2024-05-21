package chap04.vo;

public class Data {
	String name;
	int age;
	
	//생성자
	
	public Data() {
		System.out.println(" 생성자 호출");
		this.name = "";
		this.age = 0;
	}
	
	
	public String toString() {
		return "Data [name="+this.name+",age ="+age+"]";
	}
	public Data(String name) {
		this(name,0);
	}
	public Data(int age) {
		this("",age);
	}
	
	public Data(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
}
