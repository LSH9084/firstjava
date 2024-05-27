package chap10.map;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSortCollection {
	public static void main(String[] args) {
		int[] num = {8,3,9,10,3};
		System.out.println(Arrays.toString(num));
		for(int i : num) {
			System.out.println(i);
		}
		System.out.println("==========");
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
			
		}
		System.out.println("==========");
		for(int i=0; i<num.length-1; i++) {
			for(int j=i+1; j<num.length; j++) {
				System.out.println(i+":"+j);	
				if(num[j]>num[i]) {
					int replace = num[i];
					num[i] = num[j];
					num[j] = replace;
				}
			}	
			System.out.println(Arrays.toString(num)+"=======");
		}
		System.out.println(Arrays.toString(num));
		System.out.println("==========");
		
		for(int i=0; i<num.length-1; i++) {
			for(int j=i+1; j<num.length; j++) {
				if(num[i]>num[j]) {
					int replace2 = num[i];
					num[i] = num[j];
					num[j] = replace2;
				}
			}
		}
		System.out.println(Arrays.toString(num));		
		System.out.println("List - bubble방식 정렬");
		var list = new ArrayList<Integer>();
		list.add(10);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(9);
		System.out.println(list);		
		for(int t=0; t<list.size()-1;t++) {
			for(int k=0; k<list.size()-(t+1); k++) {
				var target1 = list.get(k);
				var target2 = list.get(k+1);
				
				if(target1 > target2) {
					list.set(k, target2);
					list.set(k+1, target1);
				}				
			}
			System.out.println(list+"==");
		}
		System.out.println(list+"=last align");
	}
	
	
	
}
