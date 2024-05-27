package chap10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Collection_Q01{
	public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			int count = sc.nextInt();
			List<Integer> se = new ArrayList<Integer>();
			
			for(int i=0; i<count; i++) {
				
				double lottoNum = (int)(Math.random()*65+1);
//				System.out.println((int)lottoNum);
				se.add((int)lottoNum); 
				
			}
//			System.out.println(se);
			
			Set<Integer> se2 = new HashSet<Integer>();
			se2.addAll(se);
//			System.out.println(se2);
//			System.out.println(se2.size());
			while(se2.size()!=6) {
				double lottoNum = (int)(Math.random()*65+1);
				se2.add((int)lottoNum);
			}
//			System.out.println(se2);
			
			if(se2.size()==6) {
				double lottoNum = (int)(Math.random()*65+1);
				se2.add((int)lottoNum);
				if(se2.size()==7) {
					se2.remove((int)lottoNum);
					System.out.println(se2+"+[bonus Number = "+(int)lottoNum+"]");
				} else {
					double lottoNum2 = (int)(Math.random()*65+1);
					se2.add((int)lottoNum);
				}
			}
			
			
	}
	
	
	
	
	
}
