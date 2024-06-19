package chap20;

public class DaemonThreadTest {
	public static void main(String[] args) {
		
		Thread.State state;
		Thread t1 = new Thread() {
			public void run() {
				int i =0;
				while(true) {
					if(i>100000) {
						break;
					} else {
						i++;
//						System.out.println("i = "+i);
					}
				}
			}
		};
		
		
		state = t1.getState(); //스레드의 상태 추출
		System.out.println("스레드 상태: " + state);
		
		t1.start();
		state = t1.getState();
		System.out.println("스레드 상태: " + state);
		
		Thread.interrupted(); //스레드 강제 종료
		try {
			Thread.sleep(1000); //1초 동안 스레드 대기
		} catch (Exception e) {}
		
		state = t1.getState();
		System.out.println("스레드 상태: "+state);
		System.out.println("메인스레드 종료");
	}
	
	
}
