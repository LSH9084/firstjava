package chap15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class E03FileStream {
	public static void main(String[] args) {
		System.out.println("==한글 한문자 처리: 3byte구성 , 3read() = 한글자==");
		try ( FileInputStream fis1 = new FileInputStream("hangle.txt");
				FileOutputStream fos1 = new FileOutputStream("hangle2.txt")){
			
			fos1.write(fis1.read());
			fos1.write(fis1.read());
			fos1.write(fis1.read());
			fos1.write(fis1.read());
			fos1.write(fis1.read());
			fos1.write(fis1.read());
			
		} catch (Exception e) {	}
		
		try ( FileReader fr1 = new FileReader("hangle.txt");
				FileWriter fw1 = new FileWriter("hangle3.txt")){
			fw1.write(fr1.read());
			fw1.write(fr1.read());
			fw1.write(fr1.read());
			fw1.write(fr1.read());
			
			System.out.println("==이건 글자 한칸당 한번임 == byte단위로 읽어내는 중==");
			
		} catch (Exception e) {}
		
	}
}
