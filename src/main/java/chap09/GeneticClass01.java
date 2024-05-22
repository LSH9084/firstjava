package chap09;

public class GeneticClass01 {
	public static void main(String[] args) {
		GenClass<Integer> gc = new GenClass<Integer>();
		gc.setT(20);
		System.out.println(gc.getT());
		GenClass<String> gc2 = new GenClass<String>();
		gc2.setT("안녕");
		System.out.println(gc2.getT());
		GenClass gc3 = new GenClass();
		gc3.setT("안녕");
		System.out.println(gc3.getT());
		gc3.setT(20);
		System.out.println(gc3.getT());
	}
}
class GenClass <T>{
	private T t;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t =t;
	}
}