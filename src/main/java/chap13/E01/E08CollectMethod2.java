package chap13.E01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class E08CollectMethod2 {
	public static void main(String[] args) {
		
		List<String> locals = Arrays.asList("서울","대전","대구","광주","부산","제주");
		System.out.println(locals);
		
		List<String> reverseLocals = locals.stream().collect(Collectors.collectingAndThen(Collectors.toList(), x->{
			Collections.reverse(x);
			return x.stream();
		})).collect(Collectors.toList()); //다시 리스트 구조가아닌 set이나 다른 구조를 뛰고 싶을때를 위해서 다시 stream()을 걸어주고 collect를 통해서 재 변환 할 수 있음
		System.out.println(reverseLocals);
		
		List<String> G7 = Stream.of("미국","영국","프랑스","독일","이탈리아","중국","일본").collect(Collectors.collectingAndThen(Collectors.toList(),Collections::unmodifiableList	));
		System.out.println(G7);
		System.out.println(G7);
//		G7.add("대한민국");
//		System.out.println(G7); //unmodifiableList를 쓰면 값을 수정할 수 없다.
		
		List<Integer> scores = Arrays.asList(100,100,60,85,90);
		System.out.println("평균: "+scores.stream().collect(Collectors.averagingInt(i -> i)));
		
		List<Score> list1 = Arrays.asList(
				new Score("홍길동",100,100,90),
				new Score("홍길순",20,90,80),
				new Score("김리",60,80,90)
				);
		
		double avgMat = list1.stream().collect(Collectors.averagingDouble(Score::getMat));
		System.out.println(avgMat);
				
		
	}
}
@Data
@RequiredArgsConstructor
//@AllArgsConstructor
class Score {
	private final String name;
	private final int kor;
	private final int eng;
	private final int mat;
	private String msg;
}