package chap10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Tree {

	public static void main(String[] args) {
		var arr = new ArrayList<String>();
		arr.add("사자1");arr.add("사자2");arr.add("사자4");
		
		System.out.println(arr);
		var trs = new TreeSet<String>();
		trs.addAll(arr);
		System.out.println(trs);
		
		System.out.println(">Treeset에 사자3 추가[add()]");
		trs.add("사자3");
		System.out.println(trs);
		
		
		System.out.println(trs);
		
		String addString = "사자5";
		trs.add(addString);
		System.out.printf("TreeSet에 %s가 없으면 추가[contains()]\n",addString);
		System.out.println(trs.contains(addString));
		if(trs.contains(addString)) {
			System.out.printf("TreeSet에 %s가 있습니다.\n",addString);
		} else {
			System.out.println("없음");
		}
		

		System.out.println(">TreeSet에 %s보다 크거나 같은 값 중에 제일 가까운 값을  출력[celling()]");
		System.out.printf("%s\n",trs.ceiling("사자3"));
		System.out.printf("%s\n",trs.floor("사자151646"));
		System.out.printf("%s\n",trs.higher("사자4888888888"));
		System.out.printf("%s\n",trs.lower("사자2"));
		System.out.printf("%s\n================\n",trs.first());
		System.out.printf("%s\n=============\n",trs.last());
		
		Iterator<String> it = trs.descendingIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		
	}

}
