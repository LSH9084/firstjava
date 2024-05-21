package chap04.vo;

public class Data02 {
	
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Data02() {
		this("김길동",10);
	}
	
	@Override
	public String toString() {
		return "Data02 [name=" + name + ", age=" + age + "]";
	}
	public Data02(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
