package chap13.E01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class E06TerminalOperations {
	public static void main(String[] args) {
		
		//최종 연산 : toArray(),forEach(),........
		
		int[] num1 = IntStream.range(0,10).toArray();
		
		System.out.println(Arrays.toString(num1));
		
		Arrays.stream(num1).forEach(v->System.out.println(v));
		System.out.println("==forEach(),forEachOrdered()==");
		
		List<Integer> list1 = Arrays.asList(4,2,8,5,10);
		
		System.out.println("==직렬 forEach()=="); //순서대로 처리
		list1.forEach(System.out::println);
		
		
		System.out.println("==병렬 forEach()====");
		list1.parallelStream().forEach(v->System.out.println(v)); //순서 상관없이 먼저 처리되는 순서대로
		
		System.out.println("==병렬 forEachOrdered()====");
		list1.parallelStream().forEachOrdered(System.out::println); //foreachordered를 쓰면 병렬 처리하더라도 순서를 재정렬 해서 출력
		
		System.out.println("==일반적인 합계 구하기==");
		int sum = 0;
		int [] num2 = {1,2,3};
		for(int i :num2) {
			sum += i;
		}
		System.out.println(sum);
		
		System.out.println("==reduce()를 사용해서 구하기==");
		int sum2 = Arrays.stream(num2).reduce(0, (x,y)->x+y);
		System.out.println(sum2);
		
		int sum3 = Arrays.stream(num2).reduce(0, Integer::sum);
		System.out.println(sum3);
		
		int sum4 = IntStream.range(1, 101).reduce(0, (x,y)->x+y);
		System.out.println(sum4);
		
		int fac1 = IntStream.range(1, 5).reduce(1, (x,y)->x*y);
		System.out.println(fac1);
		
		//null이 발생하는것을 대비한 타입으로 null인경우 default값을 설정해줌. 
		int sum5 = 0;
		OptionalInt op1 ;
		
		sum5 = IntStream.range(7, 11).reduce(6, Integer::sum);
		System.out.println(sum5);
		
		op1 = IntStream.range(6, 11).reduce(Integer::sum);
		System.out.println(op1.getAsInt());
		
		OptionalInt op2 = OptionalInt.empty();
//		op2 = OptionalInt.of(123);
		System.out.println("====");
		if(op2.isEmpty()) {
			System.out.println("비어있음.");
			System.out.println(op2.isPresent());
		} else {
			System.out.println(op2.getAsInt());
			System.out.println(op2.isPresent());
		}
		System.out.println("=====");
		OptionalInt t1 = OptionalInt.of(0);  //0 save
		OptionalInt t2 = OptionalInt.empty(); // null save
		System.out.println(t1.isPresent());
		System.out.println(t2.isPresent());
		
		System.out.println(t1.getAsInt());
//		System.out.println(t2.getAsInt()); 값이 없어서 뽑아오지 못함
		
		Optional<String> t3 = Optional.ofNullable(null);
		Optional<String> t4 = Optional.empty();
		System.out.println("==null값을 주는것과 empty의 값은 같다==");
		System.out.println(t3==t4);
		System.out.println(t4.equals(t3));
		
		IntStream.range(1, 6).reduce(Integer::sum).ifPresent(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
