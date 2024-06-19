package chap20;



public class SynThreadTest01 {
	
	
	public static void main(String[] args) {
		Food food1 = new Food();
		Waiting waiter = new Waiting(food1);
		waiter.setName("웨이트 스레드");
		
		Chef chef = new Chef(food1);
		chef.setName("주방장 스레드");
		
		waiter.start();
		chef.start();
	}
}
//음식 클래스
class Food {
	private static String[] menu = {
		"돈까스","오므라이스","된장찌개","육개장"
	};
	String foodName;
	
	public Food() {}
	
	public void receiveOrder() {
		synchronized (this) {
			for(int i=0; i<5; i++) {
				System.out.println("웨이터가 손님에게 주문을 받습니다.");
			}
			
			int menuNum = (int)(Math.random()*3);
			foodName = menu[menuNum];
			
			System.out.println("웨이터가 "+foodName+" 주문을 주방에 전달합니다.");
			System.out.println();
			
			this.notify(); // 정지 상태인 스레드를 실행 상태로 변경
			try {
				wait(); // 실행 중인 자신은 정지 상태로 이동
			} catch (Exception e) {}
			
		}
		
	}
	
	// 음식을 만드는 메서드
	public void makeFood() {
		synchronized (this) {
			for(int i=0; i<5; i++ ) {
				System.out.println("주방장이 "+foodName+" 를 만듭니다.");
			}
			
			System.out.println("주방장이 "+foodName+" 를 다 만들었습니다.");
			System.out.println();
			
			this.notify(); // 정지 상태인 스레드를 실행 상태로 변경
			try {
				wait(); // 실행 중인 자신은 정지 상태로 이동
			} catch (Exception e) {}
			
		}
		
		
		
	}
}

class Waiting extends Thread{
	Food food;
	
	public Waiting(Food food) {
		this.food = food;
	}
	@Override
	public void run() {
		while(true) {
			food.receiveOrder();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {}
		}
	}
}

class Chef extends Thread{
	Food food;
	
	public Chef(Food food) {
		this.food = food;
	}
	
	@Override
	public void run() {
		while(true) {
			food.makeFood();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {}
		}
	}
}















