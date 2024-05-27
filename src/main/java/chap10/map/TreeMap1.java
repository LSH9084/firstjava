package chap10.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMap1 {
	public static void main(String[] args) {
		
		
		System.out.println("HashMap은 정렬되지 않은 Key,Value형태");
		Map<String, String> h = new HashMap<String, String>();
		h.put("1902893", "선풍기1");
		h.put("1801438", "선풍기3");
		h.put("1803962", "선풍기4");
		h.put("1722761", "선풍기2");
		System.out.println(h);
		
		Map<String,String> m = new TreeMap<String, String>();
		m.putAll(h);
		System.out.println(m);
		
	}
}
