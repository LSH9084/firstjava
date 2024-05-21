package chap04.vo;

public class VO {
	int a = 100;
	String name = "홍길동";
	private int age; //클래스 내에서 접근 가능
//	var phone = 1000; //타입 추론 (지역 변수에서 만 가능)
	public void sayHello() {
		System.out.println("hello world!!");
	}
	public int result() {
		return 100;
	}
	
	public VO() {
		
	}


}