package chap20;

import java.util.stream.IntStream;

public class ThreadTest02 {
	
	
	public static void main(String[] args) {
		// join(): 다른 스레드의 실행이 완료될 때 까지 기다리는 메서드
		Sum sum1 = new Sum();
		Sum2 sum2 = new Sum2();
		sum1.start();
		sum2.start();
		
		try {
			sum1.join();
			sum2.join();
		} catch (Exception e) {}
	
		
		System.out.println("두 스레드의 sum 합계: "+(sum1.sum+sum2.sum));
		
	}
}


class Sum extends Thread {
	int sum = 0;
	public void run() {
		IntStream iss = IntStream.range(1, 100);
		sum = iss.reduce(0, (x,y) -> x+y);
		System.out.println(sum);
	}
}

class Sum2 extends Thread {
	int sum = 0;
	public void run() {
		IntStream iss = IntStream.range(100, 200);
		sum = iss.reduce(0, (x,y) -> x+y);
		System.out.println(sum);
	}
}