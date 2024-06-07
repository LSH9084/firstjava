package chap15.pra;

import java.io.FileOutputStream;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		FileOutputStream fos1 = null;
		try {
			fos1 = new FileOutputStream("test2.txt");
			fos1.write(65);
			fos1.write(66);
			fos1.write(67);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				fos1.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
}
