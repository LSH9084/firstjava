package chap09.Interface;

public class ComplexerMain2 {
	public static void main(String[] args) {
		Fax fax = new Fax() {

			@Override
			public void send(String tel) {
				System.out.println("여기는 익명 구현 객체의 send()method");
				
			}

			@Override
			public void receive(String tel) {
				System.out.println("여기는 익명 구현 객체의 receive()method");
				
			}
			
		};
		fax.send("1234");
		fax.receive("5678");
		
	}
}
