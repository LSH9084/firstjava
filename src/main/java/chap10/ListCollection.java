package chap10;

import java.util.ArrayList;
import java.util.List;

public class ListCollection {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("동길이");
		list.add("동순이");
		list.add("동길이홍");
		
		System.out.println(list);
		list.forEach((v)->{
			System.out.println(v);
		});
		
		for(String s : list) {
			System.out.println(s);
		}
		list.forEach(System.out::println);
		
		list.add(4,"김길동");
		list.forEach(System.out::println);
		
		System.out.println("--수정: set(index, data)");
		
		list.set(3, "하하");
		System.out.println("===========sdjkfsdlkjf");
		for(int i=0; i<list.size();i++) {
			list.get(i);
		}
		list.forEach(System.out::println);
		System.out.println("====특정 위치 값 추출==========");
		System.out.println(list.get(5));
		
		System.out.println("=====사이즈찾기 = 이름.size()====");
		System.out.println(list.size());
		
		System.out.println("====특정 값에 대한 indexOf()====");
		System.out.println(list.indexOf("하하"));
		System.out.println(list.indexOf("하하001"));
		
		System.out.println("=====remove()=====");
		System.out.println(list.remove(5));
		System.out.println("====");
		list.forEach(System.out::println);
		list.remove(list.indexOf("하하"));
		System.out.println("===");
		list.forEach(System.out::println);
		
		
		System.out.println("===");
		List<String> delList = new ArrayList<String>();
		delList.add("동길이");
		delList.add("홍길동");
		
		list.removeAll(delList);
		System.out.println("=====");
		list.forEach((v)->{
			System.out.println(v);
		});
		
		System.out.println("============");
		
		
		
		
		
		
		
		
		
		
	}
}
