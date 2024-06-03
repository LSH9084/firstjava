package chap15.pra;

import java.io.FileWriter;

public class FileWriterEx {
	public static void main(String[] args) {
		
		try {
			FileWriter fw1 = new FileWriter("test4.txt");
			fw1.write('a');
			char[] buf = {'b','c','d'};
			fw1.write(buf);
			fw1.write(buf,1,2);
			fw1.write("저는 홍길동 입니다.");
			fw1.flush();
			fw1.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
