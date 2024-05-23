package chap10.pra;

import java.util.ArrayList;
import java.util.List;

public class ListEx3 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Circle(3.0));
		list.add(new Rectangle(3,4));
		list.add(new Circle(5));
		list.add(new Rectangle(5,6));
		
		System.out.println(sumArea(list));
		System.out.println(sumLength(list));
		
		
	}
	
	private static double sumLength(List list) {
		double sumlength = 0;
		
		for(int i=0; i<list.size();i++) {
			Shape s = (Shape)list.get(i);
			sumlength += s.length();
		}
		return sumlength;
	}
	
	private static double sumArea(List list) {
		double sumarea =0;
		
		for(int i =0; i<list.size();i++) {
			sumarea += ((Shape)list.get(i)).area();
		}
		return sumarea;
	}
}


