package chap15.pra;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx3 {
	public static void main(String[] args) {
		
		FileInputStream fis1 = null;
		try {
			fis1 = new FileInputStream("src/main/java/chap15/pra/InputStreamEx.java");
			int i = 0;
			byte [] buf = new byte[fis1.available()];
			while((i=fis1.read(buf,0,buf.length)) != -1) {
				System.out.println(new String(buf,0,i));
			}
		} catch (IOException e) {}
		finally {
			try {
				fis1.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
