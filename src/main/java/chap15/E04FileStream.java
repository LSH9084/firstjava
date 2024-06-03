package chap15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Scanner;

public class E04FileStream {
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("이름을 입력하세요,>:");
//		String name = sc.nextLine();
////		name += "\n"+name;
//		System.out.println(name);
//		
//		
//		InputStream is1 = new ByteArrayInputStream(name.getBytes());
//		
//		try( FileOutputStream fw1 = new FileOutputStream("hangle4.txt")) {
//			int i;
//			while((i=is1.read()) != -1 ) {
//				fw1.write(i);
//			}
//		} catch (Exception e) {	}
		
		System.out.println("버퍼를 이용한 파일스트림 처리====================");
		//하는 이유 = 장치간에 데어터의 전송속도,처리속도를 최적의 상태로 유지하기 위해
		
		
		try (FileInputStream fis1 = new FileInputStream("pom.xml");
				BufferedInputStream bip1 = new BufferedInputStream(fis1);
				FileOutputStream fos1 = new FileOutputStream("test_pom2.xml");
				BufferedOutputStream bop1 = new BufferedOutputStream(fos1)){
			
			int i;
			while((i=bip1.read()) != -1) {
				bop1.write(i);
			}
			
		} catch (Exception e) {}
		finally {
			System.out.println("파일복사 완료");
		}
		
		System.out.println("== download ==");
		
		try {
			URL url = new URL("https://ssl.pstatic.net/melona/libs/1496/1496326/ed34de11baccdc54aed2_20240523115950073.jpg");
			InputStream in = new BufferedInputStream(url.openStream());
			OutputStream out = new BufferedOutputStream(new FileOutputStream("test001.jpg"));
			
			for (int i ; (i=in.read()) != -1;) {
				out.write(i);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
		}
		
		
		
	}
}
