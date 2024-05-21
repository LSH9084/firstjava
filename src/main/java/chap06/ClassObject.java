package chap06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class ClassObject {
	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
		
		String A = new String("길순이");
		String B = "길순이";
		String C = "길순이";
		
		System.out.println(B==C);
		System.out.println(A.equals(B));
		obj1.setName("홍길동");
		obj1.setAge(17);
		obj1.setGrade(100);
		System.out.println(obj1);
		
	}
}
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class MyObject {
	String name ;
	int age;
	int grade;
}