package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E01FileStream {
	public static void main(String[] args) {
		
		FileInputStream fis1 = null;
		FileOutputStream fos1 = null;
		
		try {
			//경로를 생략하면프로젝트 폴더가 root("/")이고 root가 현재 위치가 됨.
			fis1 = new FileInputStream("pom.xml");
			fos1 = new FileOutputStream("test_pom.xml");
			
			int i ;
			try {
				while ( (i=fis1.read()) != -1 ) { //데이터가 존재하면 처리해라
					fos1.write(i);
					System.out.print((char)i);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} 
			
		} catch (Exception e) {
			
		}
		
	}
}
