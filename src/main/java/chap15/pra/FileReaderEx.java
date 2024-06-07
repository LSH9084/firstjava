package chap15.pra;

import java.io.FileReader;

public class FileReaderEx {
	public static void main(String[] args) {
		
		FileReader fr1 = null;
		
		try {
			fr1 = new FileReader("src/main/java/chap15/pra/InputStreamEx.java");
			int i=0;
			while((i=fr1.read()) != -1) {
				System.out.print((char)i);
			}
		} catch (Exception e) {}
		
		finally {
			try {
				fr1.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	}
}
