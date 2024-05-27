package chap10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lombok.ToString;

public class ListLinked {

	static List<String> list1 = new ArrayList<String>();
	static List<String> list2 = new LinkedList<String>();
		
		
		public static void main(String[] args) {
			list2.add("한화"); list2.add("이상훈");
			list1.add("dog");
			toString("Array & Linked");
			System.out.println("linked size : "+list2.size());
			System.out.println("array size : "+list1.size());
			
		}
		
		public static void toString(String title) {
			System.out.println(title+list1);
			System.out.println(title+list2);
		}
}
