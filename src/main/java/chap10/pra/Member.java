package chap10.pra;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Member{
	String name;
	int age;
	
	@Override
	public String toString() {
		return "("+name+","+age+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member m = (Member)obj;
			return this.name.equals(m.name)&& this.age == m.age; 
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode() + age;
	}
	

}
