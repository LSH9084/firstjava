package chap15.pra;

import java.io.FileInputStream;

public class FileInputStreamEx2 {
	public static void main(String[] args) {
		
		try {
			FileInputStream fis1 = new FileInputStream("src/main/java/chap15/pra/InputStreamEx.java");
			int i=0;
			byte[] buf = new byte[fis1.available()];
			while((i=fis1.read(buf)) != -1) {
				System.out.println(new String (buf, 0 , i));
			}
		} catch (Exception e) {}
		
	}
}
