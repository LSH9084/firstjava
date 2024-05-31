package chap13.E02;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;



public class E06CollectMethod07 {
	public static void main(String[] args) {
		//mapToObj(): 스트림 요소 연산하는 과정에서 자료형을 변경 할 경우
		
		Map<Boolean, List<Long>> m1 = IntStream.range(1, 11).mapToLong(x->x).boxed().collect(Collectors.partitioningBy(i -> i%2==0));
		
		List<Long> odd = m1.get(false);
		
		System.out.println(odd);
		
		odd.forEach(System.out::println);
		
		List<Long> notodd = m1.get(true);
		System.out.println("======");
		notodd.forEach(System.out::println);
		
		for (boolean key : m1.keySet()) {
			if(key == true) {
				System.out.println("\n짝");
			}
			else {
				System.out.println("\n홀");
			}
			List<Long> num1 = m1.get(key);
			num1.forEach(v-> {
				System.out.print(v+" ");
				});
			
		}
		System.out.println("=====");
		Map<Boolean, List<Long>> m2 = IntStream.range(1, 11).mapToObj(Long::new).collect(Collectors.partitioningBy(i->i%2==0) );
		System.out.println(m2);
		
		//filter(Predicate함수형 인터페이스 : x -> boolean) : 스트림 요소를 원하는 데이터만 제어할 경우
		
		List<Integer> list1 = Arrays.asList(1,3,5,7,9);
		List<Integer> list2 = Arrays.asList(2,4,6,8,10);
		System.out.println("=====");
		List<Integer> list3 = Stream.of(list1,list2).flatMap(List::stream) // x->x.stream()과 같음
									.sorted().filter(x->x%3==0).collect(toList());
		
		System.out.println(list3);
		List<String> list4 = Arrays.asList("RED","bad","web","bed","rad");
		list4.stream().filter(x -> 0 < x.toUpperCase().indexOf("ED")).forEach(System.out::println);
		
		Predicate<String> condition1 = x -> 0 < x.toUpperCase().indexOf("ED");
		
		list4.stream().filter(condition1).forEach(System.out::println);
		
		System.out.println("==포함 X==");
		Predicate<String> condition2 = Predicate.not(condition1);
		list4.stream().filter(condition2).forEach(System.out::println);
		
		// sorted() : 스트림 요소를 정렬할 경우, 정렬 기준 asccending 기본
		Integer [] int1 = {1,3,5,7,9};
		Integer [] int2 = {2,4,6,8,10};
		
		Stream<Integer[]> stm1 = Stream.of(int1,int2);
		List<Integer> stm2 = stm1.flatMap(x -> Arrays.stream(x)).sorted().collect(toList());
		System.out.println(stm2);
		
		Stream<Integer[]> stm3 = Stream.of(int1,int2);
		List<Integer> stm4 = stm3.flatMap(Arrays::stream).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(stm4);
		
		System.out.println("학생점수-=");
		
		List<Score> scores = Arrays.asList( 
				new Score("홍길동",100,100,90),
				new Score("홍길순",20,90,80),
				new Score("김리",60,80,90)
				);
		
		System.out.println(scores);
		System.out.println("==이름 순 정렬==");
		List<Score> sortName = scores.stream().sorted((x,y)->{
//			return x.getName().compareTo(y.getName());  
			return y.getName().compareTo(x.getName());  //x가 앞이면 오름차순 뒤면 내림차순 문자정렬일떄는 compareTo를 사용해서 숫자를 정렬할떄는 x - y를 사용해서 내림 오름은 같음
		}).collect(Collectors.toList());
		System.out.println(sortName);
		
		sortName.stream().forEach(System.out::println);
		System.out.println("======");
		List<Score> engScore = scores.stream().sorted((x,y) -> y.getEng() - x.getEng()).collect(toList());
		System.out.println(engScore);
		scores.stream().sorted((x,y)->x.getEng() - y.getEng()).collect(toList()).forEach(System.out::println);
		
		List<ScoreBoard> boards = Arrays.asList(
				new ScoreBoard("홍길동", 61, 71, 81),
				new ScoreBoard("동길이", 62, 72, 82),
				new ScoreBoard("동순이", 100, 100, 61)		
				);
		
		System.out.println("==정렬==");
//		boards.stream().forEach(System.out::println);
		
		boards.stream().sorted().collect(toList()).forEach(System.out::println);
		System.out.println("==중복 제거==");
		List<Integer> numl1 = Arrays.asList(3,3,3,3,3,4,4,4,4,5,5,5,5,6,7);
		numl1.stream().distinct().sorted((x,y)-> y -x).collect(toList()).forEach(System.out::print);
		
		System.out.println("==peek()==");
		Stream.of("mouse","cow","hourse","monkey").peek(x->System.out.println("처리할 요소: "+x))
			.map(String::toUpperCase).peek(x->System.out.println("처리할내용: " + x)).forEach(x->System.out.println("최종연산결과: "+x));
		
		Stream.of("홍길동","동순이","김길동","김갑순").skip(3).forEach(System.out::println);
		
		Map<String, Long> info = Stream.of("패","승","패","승","승","승","패").skip(1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(info);
		
		Stream.generate(Math::random).map(x->(x*9)+1).map(Math::round).limit(10).sorted().forEach(System.out::println);
		
		Stream.generate(UUID::randomUUID).limit(5).forEach(System.out::println);
	}
}
@Data 
@AllArgsConstructor
class ScoreBoard implements Comparable<ScoreBoard> {
	private String name;
	private int score1;
	private int score2;
	private int score3;
	
	@Override
	public int compareTo(ScoreBoard o) {
		
		return o.getScore1() - this.getScore1(); //내림차순 숫자 
//		return this.getScore1() - o.getScore1() ; // 오름차순 숫자
//		return this.getName().compareTo(o.getName()); // 오름차순 문자
//		return o.getName().compareTo(this.getName()); //내림차순 문자
	}	
}