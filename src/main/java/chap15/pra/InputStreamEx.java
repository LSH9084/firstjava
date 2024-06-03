package chap15.pra;

import java.io.InputStream;

public class InputStreamEx {
	public static void main(String[] args) {
		try {
			InputStream in = System.in;
			int i = 0;
			while((i=in.read()) != -1) {
				System.out.print((char)i);
			}
		} catch (Exception e) {}
		
	}
}
