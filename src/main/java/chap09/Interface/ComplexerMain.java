package chap09.Interface;

public class ComplexerMain {

	public static void main(String[] args) {
		Complexer com = new Complexer();
		System.out.println(Complexer.INK);
		System.out.println(Complexer.Fax_number);
		com.print();
		com.scan();
		com.send("02-1111-4444");
		com.receive("023-151-4646");

	}

}
