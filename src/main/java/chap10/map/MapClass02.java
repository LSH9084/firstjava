package chap10.map;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class MapClass02 {
	public static void main(String[] args) {
		Map<String, Integer> scoreMap = new HashMap<String, Integer>();
		
		scoreMap.put("이순신1", 90);
		scoreMap.put("이순신2", 70);
		scoreMap.put("이순신3", 60);
		scoreMap.put("이순신4", 50);
		System.out.println(scoreMap+"=======");
		scoreMap.entrySet().forEach(v->System.out.println(v));
		Set<String> scoreSet = scoreMap.keySet();
		scoreMap.keySet().forEach(v->System.out.println(v));
		scoreMap.values().forEach(v->System.out.println(v));
		System.out.println(scoreSet);
		System.out.println("=================");
		
		Object[] obj =  scoreSet.toArray();
		String[] arrs = new String[obj.length];
		System.out.println(arrs+"======");
		
		for( Object v : obj) {
			System.out.println((String)v+" , "+scoreMap.get((String)v));
			
		}
//		System.out.println(Arrays.toString(arrs));
		
		Iterator<String> iter = scoreSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		Vector<String> v = new Vector<String>();
		v.add("홍길이");
		v.add("동길이");
		Enumeration<String> enu = v.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		
		
	}
}
