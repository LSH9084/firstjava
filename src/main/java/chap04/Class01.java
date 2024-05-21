package chap04;

import java.util.Arrays;

import chap04.vo.VO;
import chap04.vo.VO2;

public class Class01 {
	public static void main(String[] args) {
		VO2 myData = new VO2();
		myData.name = "홍길동";
		myData.age = 15;
		myData.height = 175;
		
		System.out.println(myData.age+"\n"+myData.name+"\n"+myData.height);
		
		VO3 myData2 = new VO3();
		myData2.address = "신주로";
		System.out.println(myData2.address);
		myData2.tel = "010-5706-9084";
		System.out.println(myData2.tel);
		System.out.println(myData2);
		
		
	}
}

class VO3 {
	String address;
	String tel;
	
	private String job;
}
