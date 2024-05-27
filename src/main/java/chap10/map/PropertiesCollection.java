package chap10.map;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesCollection {
	public static void main(String[] args) {
		
		Properties p = new Properties();
		p.setProperty("10", "20"); //중복 안됨
		p.setProperty("11", "21");
		p.setProperty("12", "22");
		p.setProperty("13", "23");
		p.setProperty("9", "24");
		p.setProperty("21", "25");
		System.out.println(p);
		Enumeration e = p.propertyNames();
		while(e.hasMoreElements()) {
			String key = (String) e.nextElement();
			System.out.println(p.getProperty(key)+":"+key);
		}
		
		
		
		
		
	}
}
