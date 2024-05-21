package chap05;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student {
	String name;
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	public class Score {
		int eng;
		int mat;
		public void showInfo() {
			System.out.println(name);
			System.out.println(eng);
			System.out.println(mat);

		}
	}

}
 
	