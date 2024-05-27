package chap10.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapClass {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(6,5);
		map.put(7,5);
		map.put(3,9);
		map.put(1,9);
		System.out.println(map);
		
		Set<Integer> keys =  map.keySet();
		System.out.println(keys);
		
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(keys);
		System.out.println(list);
		
		keys.forEach(x->System.out.println(x));
		System.out.println("================="+map.size()+"-===============");
		System.out.println(map.containsKey(7));
		int num1 = 6;
		if(map.containsKey(num1)) {
//			System.out.println(map.get(1));
			map.remove(num1); System.out.println(map);
		} else {
			System.out.println("해당key가 없습니다.");
		}
		map.computeIfPresent(1 , (Integer key, Integer value) -> value+10);
		System.out.println(map);
		map.computeIfPresent(1, (Integer key, Integer value)-> --value);
		System.out.println(map.values());
		map.values().forEach(v->System.out.println(v));
		List<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(map.values());
		System.out.println(list2);
		list2.forEach(v->System.out.println(v));
		
		System.out.println("======");
		map.entrySet().forEach(v->System.out.println(v+"\n==========="));
		map.keySet().forEach(v-> System.out.println(v));
		
		
		
	}
}
