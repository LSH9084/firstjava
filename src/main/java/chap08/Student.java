package chap08;

import lombok.Data;

@Data
//@AllArgsConstructor

public class Student {
	private String name;
	private int grade;
	
	public Student() {}
	public Student(String name, int grade) {
		System.out.println(name+" 학생은 "+"대학교 "+grade+"학년 입니다.");
	}
	
	public void study(String study_level) {
		System.out.println("student study "+study_level);
	}
	
	public int test(int score) {
		System.out.println("your score : "+score);
		return 0;
	}
	

	

}
