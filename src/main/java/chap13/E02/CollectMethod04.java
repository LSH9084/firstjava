package chap13.E02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;

public class CollectMethod04 {
	public static void main(String[] args) {
		List<FreeBoard> list1 = Arrays.asList(
				new FreeBoard(1, "가입인사","hello"),
				new FreeBoard(2, "가입인사","반갑습니다."),
				new FreeBoard(3,"질문있습니다.","스프링 레그시 작성방법을 알려주세요")
				);
		
		long cnt1 = list1.stream().collect(Collectors.counting());
		System.out.println(cnt1);
		
		long cnt2 = list1.stream().count();
		System.out.println(cnt2);
		
		List<Integer> num1 = Arrays.asList(10,20,30);
		Integer minNum1 = num1.stream().min(Integer::compare).get();
		System.out.println(minNum1);
		
		List<Score> scores = Arrays.asList( 
				new Score ("홍",61,71,81),
				new Score ("동",50,99,51),
				new Score ("길",61,70,100)
				);
		
		scores.stream().collect(Collectors.minBy(Comparator.comparing(Score::getEng))).ifPresent(System.out::println);;
		
		scores.stream().min(Comparator.comparing(Score::getKor)).ifPresent(System.out::println);
		
		int sum1 = IntStream.range(1, 6).boxed().reduce(0, (x,y)->x+y);
		System.out.println(sum1);
		
		int sum2 = IntStream.range(1, 6).reduce(0, Integer::sum);
		System.out.println(sum2+"==");
		
		Integer sum3 = IntStream.range(1, 6).skip(3).sum();
		System.out.println(sum3);
		
		IntStream.range(1, 10).average().ifPresent(System.out::println);
		
		double avg = IntStream.range(1, 11).average().getAsDouble();
		System.out.println(avg);
		
		boolean rs1 = scores.stream().anyMatch( x -> x.getMat() >= 100 );
		System.out.println(rs1);
		
		boolean rs2 = scores.stream().allMatch( x -> x.getMat() >= 50 );
		System.out.println(rs2);
		
		List<Integer> li = Arrays.asList(4,6,2,8,10);
		li.stream().findAny().ifPresent(System.out::println);
		li.stream().findFirst().ifPresent(System.out::println);
		li.stream().parallel().filter(x->x>6).findAny().ifPresent(System.out::println);
		System.out.println("====");
		li.parallelStream().filter(x -> x>4).findAny().ifPresent(System.out::println);
		li.parallelStream().filter(x -> x>2).findFirst().ifPresent(System.out::println);
		
		
	}
}
@AllArgsConstructor
class FreeBoard {
	int a ;
	String b;
	String c;
}