package chap08;

public class ClassInherit01 {
	public static void main(String[] args) {
		Student md = new Middle("홍길동",4,"d");
		Student c = new College("신명호",3,18);
		
		md.study("harder than you");
		md.test(80);
		md.setGrade(20);
		
		
		College m2 = (College)c;
		m2.dkk();
		m2.test(50);
		
		College m3 = new College("dd", 1, 2);
		m3.test(13);
		
		
	}

	
}
