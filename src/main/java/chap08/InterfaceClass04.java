package chap08;

public class InterfaceClass04 {
	
	public static void main(String[] args) {
		Data d1 = new AscData();
		d1.setData(1,2,7,6,8);
		d1.sort();
		System.out.println(d1);
		
		Data d2 = new DescData();
		d2.setData(5,5,6,7,2,1,3);
		d2.sort();
		System.out.println(d2);
	}
}
