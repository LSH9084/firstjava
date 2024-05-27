package Chap11;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E03StringMethod {
	public static void main(String[] args) throws UnsupportedEncodingException, ClassNotFoundException {
		String str = "Hello Java!!!   ";
		
		char [] data = {'d','f'};
		String str2 = new String(data);
		System.out.println(str2);
		
		System.out.println(str.length());
		System.out.println("인덱스 번호로 문자찾기:"+str.charAt(6));
		System.out.println("문자로 인덱스번호찾기:"+str.indexOf(" "));
		System.out.println("replace:"+str.replace("Hello","Hi"));
		System.out.println("substring:"+str.substring(1,13));
		System.out.println("trim():" +str.trim().length() +"앞에는 공백미포함 뒤에는 공백포함"+str.length());
		System.out.println("concat():"+ str.concat("hello Python"));
		
		String jumin = "910205-1100548";
		System.out.println(jumin);
		int idx = jumin.indexOf("-");
		System.out.println(idx);
		String jumin1 = jumin.substring(0,6);
		
		String jumin2 = jumin.substring(7,14);
		System.out.println(jumin2);
		String rJunmin = jumin1.concat(jumin2);
		System.out.println(rJunmin);
		String front = jumin.substring(0,idx);
		String temp = jumin.substring(idx+1,jumin.length());
		String end = "";
		for(int i=0; i<temp.length(); i++) {
			if(i==0) {
				end += temp.charAt(i);
			} else {
				end += "*";
			}
		}
		System.out.println("주민번호 = "+front+"-"+end);
		
		String fruitData = "사과 바나나 귤 수박";
		String[] data2 = null;
		data2 = fruitData.split(" ");
		System.out.println(Arrays.toString(data2));
		for(String i : data2) {
			System.out.println(i);
		}
		
		byte[] b = "hello".getBytes();
		System.out.println(b.length);
		System.out.println(Arrays.toString(b));
		
		String decodeName2 = new String(b,2,3,"UTF-8");
		System.out.println(decodeName2+"====");
		
		String name = "홍길동";
		System.out.println(name.concat("길순이"));
		System.out.println(name);
		
		StringBuffer name2 = new StringBuffer("홍길순");
		System.out.println(name2);
		name2.append(":홍길영");
		name2.append(":홍");
		name2.append(":이순신");
		System.out.println(name2);
		
		StringBuilder name3 = new StringBuilder("부산");
		System.out.println(name3);
		
		name3.append(" 서울"); name3.append(" 대구");
		System.out.println(name3);
		
		Class c1 = E01EnumClassTest.class;
		System.out.println("=======\n"+c1);
		System.out.println(c1.getName());
		System.out.println(c1.getSimpleName());
		System.out.println(c1.getPackage());
		System.out.println(c1.getPackage().getName());
		
		Class c2 = Class.forName("Chap11.E02EnumValue");
		System.out.println("======\n"+c2);
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());
		System.out.println(c2.getPackage());
		System.out.println(c2.getPackage().getName());
		
		E02EnumValue e1 = new E02EnumValue();
		Class c3 = e1.getClass();
		System.out.println("======\n"+c3);
		System.out.println(c3.getName());
		System.out.println(c3.getSimpleName());
		System.out.println(c3.getPackage());
		System.out.println(c3.getPackage().getName());
		
		String sPath = c3.getResource("img.png").getPath();
		System.out.println(sPath);
		
		String data3 = "사과 바나나 수박 참외";
		String data4 = "202405/27";
		
		StringTokenizer str1 = new StringTokenizer(data4,"/");
		while(str1.hasMoreTokens()) {
			System.out.println(str1.nextToken());
		}
		
		
	}
}
