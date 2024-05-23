package chap09;

public class GeneticClass01 {
	public static void main(String[] args) {
		GenClass<Integer> gc = new GenClass<Integer>();
		gc.setT(20);
		System.out.println(gc.kdidjl());
		GenClass<String> gc2 = new GenClass<String>();
		gc2.setT("안녕");
		System.out.println(gc2.kdidjl());
		GenClass gc3 = new GenClass();
		gc3.setT("안녕");
		System.out.println(gc3.kdidjl());
		gc3.setT(20);
		System.out.println(gc3.kdidjl());
	}
}
class GenClass <T>{
	private T d;
	public T kdidjl() {
		return d;
	}
	public void setT(T k) {
		this.d =k;
		System.out.println("sdkljfkls");
	}
}