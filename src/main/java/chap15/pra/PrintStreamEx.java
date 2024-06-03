package chap15.pra;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEx {
	public static void main(String[] args) {
		
		try {
			FileOutputStream fos1 = new FileOutputStream("print.txt",true);
			PrintStream ps1 = new PrintStream(fos1);
			ps1.println("홍길동");
			ps1.println(1111);
			ps1.println(true);
			ps1.println(3.14);
			ps1.flush();
			ps1.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
