package chap15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class E08ZipUpZipClass02 {
	public static void main(String[] args) {
		
		String path1 = "c:"+File.separator+"javaStudyLsh"+File.separator+"java"+File.separator+
				"java"+File.separator+"firstjava"+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"chap02"+File.separator;
		System.out.println(path1);
		
		String [] files = new File(path1).list();
		System.out.println(Arrays.toString(files));
//		byte [] b = new byte[1024];
		
		Arrays.stream(files).filter(x->{
			String [] ext = x.split("\\.");
			if(ext.length == 2 && "zip".equals(ext[1])) {
				return true;
			}
			return false;
		}).forEach(x->{
			File zipPath = new File(path1+x.split("\\.")[0]);
			zipPath.mkdir();
			
			try (ZipInputStream zis1 = new ZipInputStream(new FileInputStream(path1+x)) ){
				ZipEntry zipEntry = null;
				while((zipEntry = zis1.getNextEntry()) != null) {
					String entryFile = path1+x.split("\\.")[0]+File.separator+zipEntry.getName();
					
					try (FileOutputStream fos1 = new FileOutputStream(entryFile)){
						
						byte [] b = new byte[1024];
						int length;
						while ((length	= zis1.read(b) ) !=-1) {
							fos1.write(b,0,length);
							
						}
					} catch (Exception e) {}
				}
				
			} catch (Exception e) {}
		});
		
	}
}
