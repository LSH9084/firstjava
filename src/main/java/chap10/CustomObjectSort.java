package chap10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CustomObjectSort {
	public static void main(String[] args) {
		List<Emplyee> a1 = new ArrayList<Emplyee>();
//		var list = new ArrayList<Emplyee>();
		a1.add(new Emplyee(3, "a6"));
		a1.add(new Emplyee(2, "a4"));
		a1.add(new Emplyee(1, "a3"));
		System.out.println(a1);
		a1.forEach(x->System.out.println(x));
		
		Collections.sort(a1);
		System.out.println(a1);
		
	}
}
@Data
@AllArgsConstructor
class Emplyee implements Comparable<Emplyee> {
	private int sabun;
	private String name;
	@Override
	public int compareTo(Emplyee o) {
		return this.sabun - o.sabun;
//		return this.name.compareTo(o.name);
	}
}