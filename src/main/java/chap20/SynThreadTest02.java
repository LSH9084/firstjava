package chap20;

public class SynThreadTest02 {
	Object objKey = new Object(); // 동기화 블록의 락으로 사용
	
	Thread t1 = new Thread("thread1") {
		public void run() {method1();}
	};
	
	Thread t2 = new Thread("thread2") {
		public void run() {method2();}
	};
	
	public synchronized void method1() { // 함수 자체를 동기화 하고 싶을때
		System.out.println("\n method1()");
		System.out.println("실행 스레드 : "+ Thread.currentThread().getName());
		System.out.println("thread1: "+ t1.getState());
		System.out.println("thread2: "+ t2.getState());
		for(long j=0; j<10000000000L; j++) {}
	}
	
	public void method2() {
		synchronized (objKey) { // 특정 구간에만 동기화 하고싶을때
			System.out.println("\n method1()");
			System.out.println("실행 스레드 : "+ Thread.currentThread().getName());
			System.out.println("thread1: "+ t1.getState());
			System.out.println("thread2: "+ t2.getState());
			for(long j=0; j<10000000000L; j++) {}
		}
	}
	
	
	
	void startAll() {
		t1.start(); t2.start();
	}
	
	public static void main(String[] args) {
		// 동기화 메서드와 동기화 블록의 락이 다른 경우에는
		// 두 메서드는 동기화 하지 않고 동시에 실행된다.!!!!
		SynThreadTest02 st = new SynThreadTest02();
		st.startAll();
	}
}


/* wait(), notify(), notifyAll()
 * 스레드를 동기화 -> 스레드가 실행 중일 때 다른 스레드는 대기상태 전환
 * 실행중인 스레드는 락을 반납하는 
 * 
 * 
 */