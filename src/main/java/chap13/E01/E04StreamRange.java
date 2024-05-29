package chap13.E01;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class E04StreamRange {
	
	static int cnt =0;
	
	public static void main(String[] args) {
		
		List<Board> board1 = new ArrayList<Board>();
		
		IntStream.range(1, 4).forEach(v->{
			board1.add(new Board(v, "title_"+v, "user_"+v, LocalDateTime.now()));
		});
		

//		board1.stream().forEach(System.out::println);
//		board1.forEach(v->System.out.println(v));
		final int[] cnt1 = {0};
		board1.forEach(x->{
			//람다식에서 사용가능한 외부변수 : 멤버변수, 지역변수 final 배열구조에 초기값
			System.out.println(x);
			cnt++;
			cnt1[0]++;
		});
		System.out.println("멤버변수로 외부변수 사용 case : "+cnt);
		System.out.println("지역변수 final 배열구조의 초기값을 사용한 case : "+cnt1[0]);
		
		
		//랜덤 수에서 스트림
		System.out.println("===============");
		IntStream stmNum1 = new Random().ints(3);
		stmNum1.forEach(System.out::println);
		
		System.out.println("======limit()=========");
		IntStream stmNum2 = new Random().ints(1,20).limit(5);
		stmNum2.forEach(v->System.out.println(v));
		
		
		
	}
}
@Data
@AllArgsConstructor
class Board {
	int no;
	String title;
	String user;
	LocalDateTime createdate;
}