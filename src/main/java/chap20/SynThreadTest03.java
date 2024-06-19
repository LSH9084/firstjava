package chap20;

public class SynThreadTest03 {

	
	
	public static void main(String[] args) {
		
	}
	
}

// 통장 클래스
class Account {
	int money ;
	
	//출금
	synchronized void withdraw() {
		//잔액이 없는 경우에는 대기 상태
		while(money == 0) {
			try {
				wait();
			} catch (Exception e) {
				break;
			}
		}
		notifyAll();
		System.out.println(Thread.currentThread().getName()+money+"원 출금");
		money = 0;
	}
	
	//입금
	synchronized void deposit() {
		while(money >0) {
			try {
				wait();
			} catch (Exception e) {
				break;
			}
		}
		System.out.println();
		money = (int)((Math.random()*5)+1)*100000;
		notifyAll();
		System.out.println(Thread.currentThread().getName()+money+"원 입금");
		
	}
}


//자원을 이용하는 객체 : 부모클래스, 자식클래스
class Parent extends Thread{
	Account account;
	
	public Parent(Account account) {
		super("부모");
		this.account = account;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				account.deposit(); // 잔액이 없으면 입금하는 동작
				sleep((int)(Math.random()*200));
			} catch (Exception e) {
				break;
			}
		} 
	}
}

// 자식클래스
class Child extends Thread{
	Account account;
	
	public Child(Account account) {
		super("자식");
		this.account = account;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if(account.money >0) {
				account.withdraw();
				sleep((int)(Math.random()*200));
				} else break;
			} catch (Exception e) {
				break;
			}
		}
	}
}
