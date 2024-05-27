package Chap11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05RegularExClass {
	public static void main(String[] args) {
		String str = "1234567890";
		
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(str);
		
		System.out.println(m.find());
		System.out.println(str.matches("^[0-9]*$"));
		
		String[] str2 = {"ASDF12","123456","QWERTY","as234aa","1324kkk"};
		String regex = "^[0-9A-Z]{6}$";
		for(String data : str2) {
			System.out.printf("%s\t %b\n",data,data.matches(regex));
		}
		
		String target = "sample@sample.com, test@test.co.kr,example@example.com";
		String regex1 = "([\\w]*@[\\w]*.com)";
		
		Pattern pattern = Pattern.compile(regex1);
		Matcher matcher = pattern.matcher(target);
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
		
		String regex3 = "[^0-9]";
		String[] str3 = {"ASDF12","123456","QWERTY","as234aa","1324kkk"};
		for(String data : str3) {
			System.out.printf("%s\t %s\n", data, data.replaceAll(regex3, ""));
		}
		
		String no = "주민등록번호: 010101-1234567"+"주민등록번호: 020202-2234567";
		
		String regex4 = "[0-9]{6}-[0-9]{7}";
		
		Pattern p4 = Pattern.compile(regex4);
		Matcher m4 = p4.matcher(no);
		
		while(m4.find()) {
			System.out.println(m4.group());
			String newNo = m4.group().substring(0,7)+"****"+m4.group().substring(11);
			System.out.println(newNo);
			
		}
		
		
		
		
		
		
		
		
	}
	
}
