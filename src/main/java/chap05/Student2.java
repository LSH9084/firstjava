package chap05;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class Student2 {
	static String name ;
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	
	public static class Score{
		int eng;
		int mat;
		
		public void showInfo() {
			System.out.println(name);
			System.out.println(eng);
			System.out.println(mat);
		}
	}
}
