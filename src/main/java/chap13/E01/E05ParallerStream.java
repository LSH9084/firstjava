package chap13.E01;

import java.util.stream.IntStream;

public class E05ParallerStream {
	public static void main(String[] args) {
		
		long processTime1 = System.currentTimeMillis();
		IntStream.range(65, 75).forEach(v->System.out.println(Thread.currentThread().getClass()+" - -"+(char)v));
		long result = System.currentTimeMillis() - processTime1;
		System.out.println("직렬 스트림 출력 시간 - "+result);
		long processTime2 = System.currentTimeMillis();
		IntStream.range(65, 75).parallel().forEach(v->System.out.println(Thread.currentThread().getClass()+" - -"+(char)v));
		long result2 = System.currentTimeMillis() - processTime2;
		
		System.out.println("병렬 스트림 출력 시간 - "+ result2);
		
	}
}
