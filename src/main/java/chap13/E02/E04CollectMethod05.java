package chap13.E02;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import chap05.Student.Score;


public class E04CollectMethod05 {
	public static void main(String[] args) {
		
		List<Integer> list1 = IntStream.range(1, 11).map(x -> x*2).boxed().collect(Collectors.toList());
		System.out.println(list1);
		
		List<chap13.E02.Score> scores = Arrays.asList( 
				new chap13.E02.Score("홍길동",100,100,90),
				new chap13.E02.Score("홍길순",20,90,80),
				new chap13.E02.Score("김리",60,80,90)
				);
		
		scores.stream().map(x -> {
			if(x.getKor()<40 || x.getEng() <40 || x.getMat()<40) {
				x.setMsg("과락 입니다");
			} else if ((x.getKor()+x.getEng()+x.getMat())/3 <60) {
				x.setMsg("불합격 입니다.");
			} else 
				x.setMsg("합격입니다.");
			return x;
		}).forEach(System.out::println);
		
		
		double engAvg = scores.stream().mapToInt(x->x.getEng()).average().getAsDouble();
		System.out.println(engAvg);
		
		OptionalDouble optional = scores.stream().mapToInt(x->x.getKor()).average();
		if(optional.isPresent()) {
			System.out.println(optional.getAsDouble());
		}else {
			System.out.println("점수를 처리할 수 없습니다.");
		}
		
		int[] num1 = {55,66,77,88,99};
		long count = Arrays.stream(num1).count();
		count = Arrays.stream(num1).filter(x->x >=70).count();
		System.out.println(count);
		
		int sum = Arrays.stream(num1).filter(x->x>=70).sum();
		System.out.println(sum);
		
		int allSum = Arrays.stream(num1).sum();
		System.out.println(allSum);
		
		
		
		
	}
}

