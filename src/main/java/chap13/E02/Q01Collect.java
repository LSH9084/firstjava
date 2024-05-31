package chap13.E02;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Q01Collect {
	
	public static void main(String[] args) {
		//1.Stream을 이용해서 구구단
		//2.현재 수중에 500,000원을 갖고 있습니다. <보기>에 나오는 항목으로 장을 봤습니다.
		//  	수중에 남는 돈은 얼마인지 reduce().메서드를 활용하여 코드 구현
		/** 보기
		 * 빵 20,000
		 * 우유 5,000
		 * 라면 10,000
		 * 옷 200,000
		 * 신발 100,000
		 * 삼겹살 50,000
		 * 소주 10,000
		 * 쌈장 2,000
		 * 상추 3,500
		 * 쌀 50,000
		 * 
		 * 남은 돈 :49,500
		 */
		//3. 1에서 100까지의 수 중에서 소수만 골라서 총 몇 개의 요소가 있는지 Stream을 이용하여 구현
		//4. 파일명들에 확장자가 누락되어 있습니다. 파일명 뒤에 '.java'를 모두 붙여서 출력하는 코드 구현
		//		보기> Sample01, Sample02....
					//	[Sample01.java , Sample02.java,...]
		//5. 로또번호를 스트림을 이용하여 난수를 발생시켜서 출력
		/**
		 * 조건
		 * -중복 값이 있으면 안된다.
		 * -1부터 45까지의 수만 올 수 있다.
		 * -순차적으로 정렬 
		 */
		System.out.println("==1번==");
		IntStream.range(2, 10).forEach(x -> {
			System.out.println("- "+x+"단 - ");
			IntStream.range(1, 10).forEach(y -> {
				System.out.println(x*y);
			});
		});
		
		System.out.println("==2번==");
		List<Buying> map1 = Arrays.asList(
				new Buying(20000, "빵"),
				new Buying(5000, "우유"),
				new Buying(10000, "라면"),
				new Buying(200000, "옷"),
				new Buying(100000, "신발"),
				new Buying(50000, "삼겹살"),
				new Buying(10000, "소주"),
				new Buying(2000, "쌈장"),
				new Buying(3500, "상추"),
				new Buying(50000, "쌀")
				);
		IntStream.range(2, 101).filter(x->{
			int i = IntStream.rangeClosed(2, x).map(y-> (x%y)==0 ? 1:0).reduce(0, Integer::sum);
			return i<2;
		}).forEach(x->System.out.println(x+"|"));
		
		
		List <String> fileList = Arrays.asList(
				"sample01","sample02","sample03","sample04"
				);
		
		System.out.println(fileList);
		
		List<String> newFileList = fileList.stream().map(x->x+".java").collect(toList());
		System.out.println(newFileList);
				
		Stream.generate(Math::random).map(x -> (x*44)+1).map(Math::round).distinct().limit(6).sorted().forEach(x-> System.out.printf("%d\n",x));
		
		
		
	}
}
@Data
@AllArgsConstructor
class Buying {
	private int num;
	private String name;
}
