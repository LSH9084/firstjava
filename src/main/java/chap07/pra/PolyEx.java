package chap07.pra;

public class PolyEx {
	public static void main(String[] args) {
		
		Parent1 d = new Child1();
		
		d.run();
		
		Parent1 p = new Child1();
		p.run();
		Child1 c = (Child1)p;
		c.eat();
	}
}
