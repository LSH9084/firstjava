package Chap11.E02;

import java.util.function.Supplier;

import lombok.AllArgsConstructor;

public class E02RunnableFun01 {
	public static void main(String[] args) {
		
		Runnable r = () ->{
			System.out.println("Runnable은 매개변수도 없으며, 반환 자료형도 없는 인터페이스");
		};
		r.run();
		
		Runnable r2 = () ->{
			System.out.println("안녕");
		};
		r2.run();
		
		Supplier<String> s1 = () ->{
			return "Supplier는 매개변수가 없지만 반환 자료형은 있음.";
		};
		
		System.out.println(s1.get());
		
		MessageCenter mc1 = new MessageCenter("Hello");
//		System.out.println(mc1.toString());
		MessageCenter main = getMsg(()->mc1);
		System.out.println(main);
	}
	public static MessageCenter getMsg(Supplier<MessageCenter> mc1) {
		return mc1.get();
	}
}
//@ToString
@AllArgsConstructor
class MessageCenter {
	private final String msg ;
	@Override
	public String toString() {
		return msg;
	}
	
}
