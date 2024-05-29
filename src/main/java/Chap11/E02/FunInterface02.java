package Chap11.E02;

import java.util.function.Consumer;

public class FunInterface02 {
	public static void main(String[] args) {
		Consumer<String> c1 = (x) ->{
			System.out.printf("%s는 1개의 매개변수는 있지만 반환할 자료형은 없습니다.",x.toUpperCase());
		};
		c1.accept("conssumer");
		System.out.println("===");
	}
}
