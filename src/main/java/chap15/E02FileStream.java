package chap15;

import java.io.FileOutputStream;

public class E02FileStream {
	public static void main(String[] args) {
		
		char chr1 = 74;
		char chr2 = 97;
		char chr3 = 118;
		
		try(FileOutputStream fos1 = new FileOutputStream("java.file")) {
			fos1.write(chr1);
			fos1.write(chr2);
			fos1.write(chr3);
			fos1.write(chr2);
			fos1.write(64);;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
