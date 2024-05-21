package chap04;

import chap04.vo.Data;
import chap04.vo.Data02;

public class ConstructorTest {

	public static void main(String[] args) {
		Data d = new Data();
		System.out.println(d.toString());
		Data d2 = new Data("강감찬",27);
		System.out.println(d2.toString());
		Data d3 = new Data("강감");
		System.out.println(d3.toString());
		Data d4 = new Data(13);
		System.out.println(d4.toString());
		
		Data02 s = new Data02();
		System.out.println(s);
		Data02 s2 = new Data02("하하",28);
		System.out.println(s2);
		
		Data3 ss = new Data3();
		ss.setAge(17);
		ss.setName("홍길동");
		System.out.println(ss.getAge());
		System.out.println(ss.getName());
		System.out.println(ss.toString());
		
		Data3 ss1 = new Data3("김길동",20);
		System.out.println(ss1.getAge()+ss1.getName()+ss1);
		
		
	}

}
