package chap04;

public class classStudent {

	public static void main(String[] args) {
		VO4 student = new VO4();
//		student.hakbun = 1;
		student.setInt(17,80,70,90);
		System.out.println(student.getHakbun());
		System.out.println(student.getEng()+"\n"+student.getKor()+"\n"+student.getMat());
		student.setTot();
		System.out.println(student.getTot());
		student.setAvg();
		System.out.println(student.getAvg());
		student.setName("이우일");
		System.out.println(student.getName());
	}

}
