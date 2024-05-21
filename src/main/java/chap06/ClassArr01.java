package chap06;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class ClassArr01 {
	public static void main(String[] args) {
		Student3[] stu = new Student3[3];
		
		stu[0] = new Student3("홍길동",10,1);
		stu[1] = new Student3("동길이",11,2);
		stu[2] = new Student3("동순이",12,5);
		stu[0].setAge(20);
		
		Student3 st01 = new Student3("홍길동",17);
		System.out.println(st01);
		
		for(int i=0; i<3; i++) {
			System.out.println(stu[i]);
		}
	}
}
@RequiredArgsConstructor
@AllArgsConstructor
@Data
class Student3{
	@NonNull
	String name;
	int age;
	@NonNull
	int grade;

}
