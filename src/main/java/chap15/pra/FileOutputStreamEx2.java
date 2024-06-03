package chap15.pra;

import java.io.FileOutputStream;

public class FileOutputStreamEx2 {
	public static void main(String[] args) {
		
		try {
			FileOutputStream fos1 = new FileOutputStream("test3.txt",true);
			byte [] b = new byte[26];
			byte data = 65;
			for (int i=0; i<b.length; i++) {
				b[i] = data;
				data++;
			}
			fos1.write(b);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
