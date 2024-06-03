package chap15.pra;

import java.io.FileInputStream;

public class FileInputStreamEx {
	public static void main(String[] args) {
		
		try {
			FileInputStream fis1 = new FileInputStream("src/main/java/chap15/pra/InputStreamEx.java");
			int i = 0;
			while((i = fis1.read()) != -1) {
				System.out.print((char)i);
			}
		} catch (Exception e) {}
		
	}
}
