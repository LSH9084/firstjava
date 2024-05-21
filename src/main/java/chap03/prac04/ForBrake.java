package chap03.prac04;

public class ForBrake {

	public static void main(String[] args) {
		target : for (int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(j==3) {
					break target;
				}
			}
		}
		System.out.println(Math.random()*6+1);
		double a = Math.random();

	}

}
