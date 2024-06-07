package chap15;

import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileClass01 {
	public static void main(String[] args) {
		
		//File클래스 : 파일이나 디렉터리에 대응
		
		String path1 = "workspace" + File.separator + "realjava" + File.separator + "src";
		System.out.println(path1);
		
		System.out.println("--File API--");
		String path3 = "c:"+File.separator+"javaStudyLsh"+File.separator+"java"+File.separator+"java"+File.separator+"firstjava"+File.separator;
		String path2 = "c:"+File.separator+"javaStudyLsh"+File.separator+"java"+File.separator+"java"+File.separator+"firstjava"+File.separator+"test2.txt";
		System.out.println(path2);
		File paths = new File(path2);
		File paths2 = new File(path3);
		String[] files = paths2.list();
		System.out.println(Arrays.toString(files));
		List<String> list1 = new ArrayList<String>(); 
		for(String fNm : files) {
			File fileDir = new File(fNm);
			if(fileDir.isDirectory()) {
				fNm = "[디렉토리]:"+ fNm;
			} else {
				fNm = "[파일]:" + fNm;
			}
			
			
			list1.add(fNm);
//			System.out.println(fNm);
		}
		list1.sort(Comparator.reverseOrder());
		list1.forEach(System.out::println);
		
		System.out.println("-- stream()--");
		String files2 [] = new File(path3).list();
		List<String> list2 = Arrays.stream(files2).map(x -> {
			File dir1 = new File(x);
			return (dir1.isDirectory() ? "[디렉토리]:"+x : "[파일]:"+x);
		}).collect(toList());
		list2.stream().sorted().forEach(System.out::println);
		
		Arrays.stream(files2).filter(x -> new File(x).isFile()).filter(x -> x.startsWith("hangle")).map(x -> {
			File dir2 = new File(x);
			dir2.delete();
			return x;
		}).forEach(System.out::println);
		
		
		
		
		try {
			FileInputStream fis1 = new FileInputStream(paths);
			int i =0;
			while ((i = fis1.read()) != -1) {
				System.out.print((char)i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
