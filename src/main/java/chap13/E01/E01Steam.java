package chap13.E01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class E01Steam {
	public static void main(String[] args) {
		var list = Arrays.asList(1,2,3,4,2,1,4);
//		System.out.println(list);
		System.out.println(list.toString());			
		
		List<Integer> list2 = new ArrayList<Integer>(new HashSet<Integer>(list));
		System.out.println("==hashset을 이용한 중복제거방식== \n"+list2);
//		for(int i : list) {
//			System.out.println(i);
//		}
		System.out.println("==stream().distinct()방식==");
		list.stream().distinct().forEach((v)->System.out.println(v)); //중복제거
		
		//배열을 스트림의 형태로 전환하는 객체
		
		String[] str1 = {"홍길동","홍길순","동길이","동순이"};
		System.out.println(Arrays.toString(str1));
		
		int [] num1 = {3,6,4,5,7,7};
		System.out.println(Arrays.toString(num1));
		
		double [] dou1 = {3.1,5.4,6.6,7.2};
		System.out.println(Arrays.toString(dou1));
		
		//스트림 객체 생성
		
		Stream<String> stm1 = Arrays.stream(str1);
		IntStream stm2 = Arrays.stream(num1);
		DoubleStream stm3 = Arrays.stream(dou1);
		
		stm1.forEach((v)->System.out.println(v)); //stream은 한번 뽑아쓰면 텅빈 상태가 되어서 다시 뽑아쓸 수 었다.
//		stm1.forEach((v)->System.out.println(v)); 이 코드를 실행시키면 오류가뜸
		System.out.println("===");
		stm2.forEach((v)->System.out.println(v));
		System.out.println("===");
		stm3.forEach((v)->System.out.println(v));
		
		DataObj[] data1 = {
			new DataObj(1, "홍길동"),
			new DataObj(2, "홍길순"),
			new DataObj(3, "길성준")
		};
//		System.out.println(Arrays.toString(data1));
		Stream<DataObj> stm4 = Arrays.stream(data1);
		System.out.println("한번만 출력 가능");
		stm4.forEach((v)->System.out.println(v));
		
		
	}
}
@Data
@AllArgsConstructor
class DataObj {
	int no;
	String name;
}
