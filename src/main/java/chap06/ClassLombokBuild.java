package chap06;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ClassLombokBuild {
	public static void main(String[] args) {
		Person person = Person.builder()
				.no(1)
				.phone("010-8888-7777")
				
				.build();
		System.out.println(person);
		
		
	}
}
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Person {
	private int no;
	private String name;
	private String phone;
	
}