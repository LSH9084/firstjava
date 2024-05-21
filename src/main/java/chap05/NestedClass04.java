package chap05;

public class NestedClass04 {
	public static void main(String[] args) {
		Student2.Score score = new Student2.Score();
		score.eng = 23;
		score.mat = 100;
		Student2.name = "홍길동";
		
		score.showInfo();
		
		
	}
	
	
	
}
