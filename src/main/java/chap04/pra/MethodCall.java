package chap04.pra;

public class MethodCall {

	public static void main(String[] args) {
		Method.printName();
		
		Method m = new Method();
		m.printEmail();
	}

}

class Method {
	static void printName() {
		System.out.println("네임실행");
		
	}
	
	void printEmail() {
		System.out.println("이메일 실행");
		printId();
	}
	void printId() {
		System.out.println("아이디 실행");
	}
	
}