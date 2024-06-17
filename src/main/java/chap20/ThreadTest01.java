package chap20;

import java.util.stream.IntStream;

public class ThreadTest01 {
	/**
	 * 1. 프로세서 : 실행파일을 실행시키면 CPU는 실행 파일의 명령어를 메모리에 로드해서
	 * 실행되며 실행된 상태를 프로세스라고 한다.
	 * 
	 * 2. 멀티 프로세서 : 동시에 여러개의 프로그램이 실행된 상태
	 * 
	 * 3. 멀티 프로그래밍 : 한 개의 CPU가 두가지 이상의 작업을 동시에 처리
	 * 하는 것( 브라우저, 음악플레이어, 문서 편집기 동시)
	 * 
	 * 4. 스레드 : 실행 중인 프로그램의 프로세서 안의 세부 실행 단위(프로그램을 실행하는
	 * 최소 단위)
	 * 
	 * 5. 멀티 테스킹 : CPU가 여러 개의 스레드를 동시에 실행하는 것
	 * 
	 * 6. 멀티 프로세싱 : 여러 개의 CPU(멀티 코어)가 여러 개의 스레드를 동시에 실행
	 * 하는 것
	 * 
	 * 만드는 법 : 1. 클래스로 만들기(단일 상속일때) 2. 인터페이스로 만들기(다중상속을 해야할 경우)
	 * 
	 * 데몬(Daemon) 스레드 : 스레드들 중에 메인 스레드가 종료될 때 함께 종료되는 스레드
	 * 
	 * 스레드 상태 제어
	 * interrupt() : 예외 발생 시 일시정지
	 * notify(), notifyAll() : 일시정지 -> 실행 대기 상태
	 * resume() : suspend()에 의해 일시 정지 상태 -> 실행 대기 상태
	 * sleep(밀리초) : 매개변수 시간동안 일시정지
	 * join() : 
	 * wait() : 동기화 블록 내에서 일시정지
	 * suspend()
	 * yield() : 실행 중 우선순위가 동일한 다른 스레드에게 실행을 양보
	 * stop() : 스레드 종료
	 */
	
	public static void main(String[] args) {
		Thread currThread = Thread.currentThread();
		System.out.println("현재 실행중인 스레드: "+currThread.getName());
		System.out.println("현재 실행중인 스레드: "+Thread.activeCount());
		
		
//		for(int i=1; i<100; i++){
//			System.out.printf("%3d ", i);
//		}
//		System.out.println();
		
		IntStream ins = IntStream.range(200,300);
		ins.forEach(v->{ System.out.printf("%3d ", v);});
		System.out.println();	
		
		MyThread01 th1 = new MyThread01();
		th1.setName("스레드 01 ");
		MyThread02 th2 = new MyThread02();
		th2.setName("스레드 02 ");
		Runnable r = new  RunnableImpl();
		Thread th3 = new Thread(r);
		th3.setName("인터페이스 스레드 ");
		th3.setPriority(Thread.MAX_PRIORITY);
		th3.setDaemon(true);

		th1.start();
		System.out.println(th1.getName()+" : 우선순위 ->"+th1.getPriority());
		th2.start();
		System.out.println(th2.getName()+" : 우선순위 ->"+th2.getPriority());
		th3.start();
		System.out.println(th3.getName()+" : 우선순위 ->"+th3.getPriority());
		
		System.out.println("메인 스레드 마지막부분: "+currThread.getName());
//		Runnable th3 = new MyThread03();
		
	}

 	
}

class MyThread01 extends Thread {
	
	public void run() {
		System.out.println("Thread 클래스 상속 방식");
		IntStream iss = IntStream.range(1, 100);
		iss.forEach(v-> {
			System.out.println(v+" ->"+Thread.currentThread());
			System.out.println("현재 실행중인 스레드 : "+Thread.activeCount());
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {}
		});
	}
}

class MyThread02 extends Thread {
	public void run() {
		System.out.println("Thread 클래스 상속 방식");
		IntStream iss = IntStream.range(100, 200);
		iss.forEach(v-> {
			System.out.println(v+" ->"+Thread.currentThread());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {}
		});
	}
}

class RunnableImpl implements Runnable {

	@Override
	public void run() {
		IntStream iss = IntStream.range(200, 300);
		iss.forEach(v -> {
			System.out.println(v+" ->"+Thread.currentThread());
			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		});
		
	}
	
}


