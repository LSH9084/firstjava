package chap03.prac04;

public class DoWhile {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		
		while(i<=100) {
			sum += i;
			i++;
		}
		System.out.println(sum);
		
		sum = 0;
		i = 1;
		do {
			sum += i;
			i++;
		} while(i<=100);
		System.out.println(sum);
		
		
		
		
	}

}
