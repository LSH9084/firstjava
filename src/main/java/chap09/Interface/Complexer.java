package chap09.Interface;

public class Complexer implements Printer,Scanner,Fax {

	@Override
	public void send(String tel) {
		// TODO Auto-generated method stub
		System.out.println(Fax_number+"에서"+tel+"로 전송");
	}

	@Override
	public void receive(String tel) {
		System.out.println(tel+"에서"+Fax_number+"로 fax수신");
		
	}

	@Override
	public void scan() {
		System.out.println("스캔 실행");
		
	}

	@Override
	public void print() {
		System.out.println("출력 실행");
		
	}

}
