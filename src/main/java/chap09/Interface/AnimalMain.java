package chap09.Interface;

public class AnimalMain {
	public static void main(String[] args) {
		
		Animal eagle = new Eagle();
		eagle.sleep();
		
		Eagle eagle1 = (Eagle)eagle;
		eagle1.eat();
	}
}
