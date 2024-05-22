package chap08;

import lombok.NoArgsConstructor;

public class College extends Student{
	private int score;
	
	public College(String name , int grade, int score) {
		super(name,grade);
		this.score = score;
	}
	public void dkk() {
		System.out.println("dd");
	}
}
