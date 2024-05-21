package chap05;

public class NestedClass01 {
	public static void main(String[] args) {
		Student st1 = new Student();
		st1.setName("홍길동");
		st1.getName();
		System.out.println(st1.getName());
		
		Student.Score st2 = st1.new Score();
		st2.setEng(90);
		st2.setMat(100);
		st2.showInfo();
		System.out.println(st2);
		
		
	}
	
	
	
}
