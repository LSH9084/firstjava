package chap09;

public class GeneticClass02 {
	public static void main(String[] args) {
		Computer<ComputerPart> cp = new Computer<ComputerPart>();
		
		cp.setComponent(new Graphics());
		cp.toInfo();
		cp.setComponent(new Memory());
		cp.toInfo();
//		cp.setComponent(new Monitor()); monitor는 컴퓨터 파트 클래스로부터 상속받지 않음 그래서 쓸수 없음
		
		Computer<ComputerPart> con = new Computer<ComputerPart>(new Memory());
		
	}
}

class Computer <T extends ComputerPart>{
	private T component;
	
	public Computer() {}
	public Computer(T component) {
		this.component = component;
		System.out.println(component.getClass().getName());
	}
	public void toInfo() {
		System.out.println(component.getClass().getName());
	}
	public void setComponent(T component) {
		this.component = component;
	}
}

class ComputerPart{
	
}

class Graphics extends ComputerPart{
	
}

class Memory extends ComputerPart{
	
}

class Monitor{
	
}