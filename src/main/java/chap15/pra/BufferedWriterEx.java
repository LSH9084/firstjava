package chap15.pra;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterEx {
	public static void main(String[] args) {
		
		try {
			FileWriter fw = new FileWriter("test5.txt");
			BufferedWriter bw1 = new BufferedWriter(fw);
			
			bw1.write('a');
			char[] buf = {'b','c','d'};
			bw1.write(buf);
			bw1.write(buf,1,2);
			
			bw1.write("저는 홍길동입니다.");
			bw1.flush();
			bw1.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
