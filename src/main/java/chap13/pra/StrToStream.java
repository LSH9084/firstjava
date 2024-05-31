package chap13.pra;

import java.util.stream.IntStream;

public class StrToStream {
	public static void main(String[] args) {
		
		String str = "자바 세상을 만들자";
		
		IntStream stm1 = str.chars();
		stm1.forEach(x-> System.out.println((char)x));
		
		
	}
}
