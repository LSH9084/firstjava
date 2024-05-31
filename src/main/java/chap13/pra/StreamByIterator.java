package chap13.pra;

import java.util.stream.Stream;

public class StreamByIterator {
	public static void main(String[] args) {
		
		Stream<Integer> stm1 = Stream.iterate(1, x->x+1).limit(10);
		
		
	}
}
