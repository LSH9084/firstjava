package chap05;

public class NestedClass03 {

	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("익명 내부 클래스 실행");
				
			}
		};
		
		r.run();
		
		Greeting r1 = new Greeting() {
			
			@Override
			public String sayHello(String name) {
				// TODO Auto-generated method stub
				return name;
			}
		};
		System.out.println(r1.sayHello("안녕"));
	}
}
	
interface Greeting{
	public String sayHello(String name);
}

