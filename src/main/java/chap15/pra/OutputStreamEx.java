package chap15.pra;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamEx {
	public static void main(String[] args) {
		
		try {
//			OutputStream out = System.out;
			Writer out = new OutputStreamWriter(System.out);
			out.write('a');
			out.write('b');
			out.write('c');
			out.write('1');
			out.write('2');
			out.write('3');
			out.write('가');
			out.write('나');
			out.write('다');
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
