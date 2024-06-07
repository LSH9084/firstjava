package chap15.pra;

import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamEx2 {
	public static void main(String[] args) {
		
		try {
			Reader in = new InputStreamReader(System.in);
			int i = 0;
			while ((i=in.read()) != -1) {
				System.out.print((char)i);
			}
		} catch (Exception e) {	}
	}
}
