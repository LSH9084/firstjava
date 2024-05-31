package chap13.E01;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//import static java.util.stream.Collectors.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.Map;

public class E07CollectMethod {
	 public static void main(String[] args) {
		
		 String [] animals = {"토끼","호랑이","고양이","강아지","고양이","고양이"};
		 
		 System.out.println(Arrays.toString(animals));
		 System.out.println("==List 변환==");
		 List<String> ani1 = Arrays.stream(animals).collect(toList());
		 System.out.println(ani1);
		 
		 System.out.println("==set 변환==");
		 Set<String> ani2 = Arrays.stream(animals).collect(toSet());
		 System.out.println(ani2);
		 
		 System.out.println("==TreeSet==");
		 TreeSet<String> ts1 = ani1.stream().collect(toCollection(TreeSet::new));
		 System.out.println(ts1);
		 
		 System.out.println("==HashMap==");
		 Map<String, Integer> ts2 = ani1.stream().collect(toMap(Function.identity(),String::length,(x1,x2)->x1+x2));  
		 System.out.println(ts2);
		 
		 System.out.println("==");
		 String[][] level1 = {
				 {"홍길동","초급"},{"홍길순","중급"},{"동순이","고급"}
		 };
		 System.out.println("==중복이 없을 경우==");
		 Map map1 = Arrays.stream(level1).collect(toMap(x->x[0],x->x[1] ));
		 System.out.println(map1);
		 System.out.println("==key가 중복이 될 경우==");
		 String[][] level2 = {
				 {"홍길동","초급"},{"홍길순","중급"},{"동순이","고급"},{"홍길동","중급"}	 
		 };
		 Map map2 = Arrays.stream(level2).collect(toMap(x->x[0],x->x[1],(x,y)->x+","+y));
		 System.out.println(map2);
		 
		 String n = "";
		 n = n + "A";
		 n = n + "A";
		 n = n + "A";
		 System.out.println(n);
		 
		 
		 
	}
}
