package chap08;

import lombok.Data;

@Data
public class Middle extends Student {
	String study_level ;

	
	public Middle(String name , int grade, String study_level) {
		super(name,grade);
		this.study_level = study_level;
		System.out.println(study_level);
	}
}
