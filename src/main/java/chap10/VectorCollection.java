package chap10;

import java.util.List;
import java.util.Vector;

import chap08.Student;

public class VectorCollection {
	public static void main(String[] args) {
		
		List v = new Vector();
		v.add("홍길동");
		v.add(new Integer(100));
		v.add(new Student());
		v.add(25);
		
		System.out.println(v);
		v.forEach((e)->{
			System.out.println(e);
		});
		System.out.println(v.size());
		System.out.println(v.indexOf(25));
		System.out.println("=====");
		int name = (int) v.get(1);
		System.out.println(name);
		Student s = (Student) v.get(2);
		System.out.println(s);
		
		System.out.println(name);
		v.set(0, "동길이");
		System.out.println(v);
		System.out.println("=========");
		v.remove(0);
		v.remove(0);
		System.out.println(v);
		
		
	}
}
