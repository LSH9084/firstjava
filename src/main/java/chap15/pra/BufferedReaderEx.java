package chap15.pra;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderEx {
	public static void main(String[] args) {
		
		FileReader fr1 = null;
		BufferedReader br1 = null;
		
		try {
			fr1 = new FileReader("src/main/java/chap15/pra/InputStreamEx.java");
			br1 = new BufferedReader(fr1);
			
			String txt =null;
			while((txt = br1.readLine()) != null) {
				System.out.println(txt);
			}
		} catch (Exception e) {}
		finally {
			try {
				fr1.close();
				br1.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
	}
}
