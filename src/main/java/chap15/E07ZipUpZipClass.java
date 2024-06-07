package chap15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class E07ZipUpZipClass {
	public static void main(String[] args) {
		
		//Zip and Unzip
		String path1 = "c:"+File.separator+"javaStudyLsh"+File.separator+"java"+File.separator+
				"java"+File.separator+"firstjava"+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"chap02"+File.separator;
		System.out.println(path1);
		
		// 블럭 : 한번 읽어오는 단위
		byte[] b = new byte[1024];
		
		String[] files = new File(path1).list();
		System.out.println(Arrays.toString(files));
		
		try (FileOutputStream fos1 = new FileOutputStream(path1+"test.zip");
				ZipOutputStream zos1 = new ZipOutputStream(fos1)){
			
			Arrays.stream(files).forEach(x -> {
				File f1 = new File(path1+x);
				try ( FileInputStream fis1 = new FileInputStream(f1)){
					ZipEntry zipEntry = new ZipEntry(f1.getName());
					zos1.putNextEntry(zipEntry);
					
					int length;
					while((length = fis1.read(b)) >= 0) {
						zos1.write(b,0,length);
					}
					
				} catch (Exception e) {	
					System.out.println(e.getMessage());
				}
			});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	
		
	}
}
