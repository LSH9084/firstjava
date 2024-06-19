package chap20;

public class ThreadStateControl01 {
	private int horseNum;
	
	public static void main(String[] args) {
//		System.out.println("== sleep()");
//		for(int i=0; i<10; i++) {
//			Thread Horse = new Horse(i+1);
//			
//			Horse.start();
//		}
//		
//		System.out.println("메인 스레드 종료");
		
//		System.out.println("-- yeild() : 실행중인 스레드 대기상태로 전환하고, 다른 스레드에게 양보");
//		System.out.println("-- 2개의 경마 스레드가 번갈아 가면서 실행");
//		
//		Horse2 horse2 = new Horse2(1);
//		Horse2 horse3 = new Horse2(2);
//		horse2.start();
//		horse3.start();
		
//		System.out.println("메인 메서드 시작");
//		Runnable r = new JoinTestThread();
//		Thread t = new Thread(r);
//		
//		t.start();
//		
//		try {
//			t.join();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		System.out.println("-- 메인 메서드 종료");
	
		VideoThread videoThread = new VideoThread();
		videoThread.start();
		
		System.out.println("videoThread상태 : "+ videoThread.getState());
		videoThread.interrupt();
		System.out.println("videoThread상태 : "+ videoThread.getState());
		try {
			videoThread.sleep(100);
		} catch (InterruptedException e) {}
		System.out.println("videoThread상태 : "+ videoThread.getState());
		System.out.println("메인 스레드 종료");
		
		
	}
	
	
	
}


class Horse extends Thread {
	private int horseNum;
	
	public Horse(int a) {
		this.horseNum = a;
	}
	
	@Override
	public void run() {
		long sleepTime = (long)(Math.random()*500);
		System.out.println(horseNum + "경마 "+ sleepTime+"만큼 sleep...");
		
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {}
		
		for (int i=1; i<=10; i++) {
			System.out.println(horseNum +"번 경마 "+100*i+"미터 통과");
		}
		System.out.println("결승선 도착");
		
		
		
	}
}

class Horse2 extends Thread {
	private int horseNum;
	boolean yieldFlag;
	
	public Horse2(int a) {
		this.horseNum = a;
	}
	
	@Override
	public void run() {
		while(true) {
			if(yieldFlag) {
				Thread.yield();
				yieldFlag = false;
			} else {
				yieldFlag = true;
				System.out.println(horseNum+ "번 경마가 지나갑니다.");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {}
				
				for(int i=0; i<10000000000L; i++) {
					
				}
			}
		}
		
	}
}


class JoinTestThread implements Runnable {

	@Override
	public void run() {
		System.out.println("run 메서드 시작...");
		first();
	}
	
	private void first() {
		System.out.println("first() 메서드 호출");
		second();
	}
	
	private void second() {
		System.out.println("second() 메서드 호출");
	}
	
}

class VideoThread extends Thread {
	public void run() {
		try {
			while (true) {
				System.out.println("동영상을 재생합니다.");
				Thread.sleep(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("interrupt()호출에 의한 동영상 종료");
		}
	}
}







