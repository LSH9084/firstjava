package Practice.E01;

import java.util.Scanner;

public class ShapeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("도형의 개수");
		int no = sc.nextInt();
		Shape[] p = new Shape[no];
		
		for(int i=0; i< no; i++) {
			int type;
			do {
				System.out.println((i+1)+"번 도형의 종류(1.점/2.수평선"+"/3.수직선/4.사각형:");
				type = sc.nextInt();
			} while(type<1||type>4);
			switch(type) {
				case 1 : p[i] = new Point();
							break;
				case 2 :
				case 3 : System.out.println("길이는:");
							int len = sc.nextInt();
							p[i] = (type == 2) ? new HorzLine(len) : new VertLine(len);
							break;
				case 4 : System.out.println("너비:");
							int width = sc.nextInt();
							System.out.println("높이:");
							int height = sc.nextInt();
							p[i] = new Rectangle(width, height);
							break;
			}
		}
		for(Shape s : p ) {
			s.print();
			System.out.println();
		}
		
	}

}
