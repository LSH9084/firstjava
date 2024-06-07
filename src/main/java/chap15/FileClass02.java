package chap15;

import static java.util.stream.Collectors.toList;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileClass02 {
	public static void main(String[] args) {
		
		//파일 속성 표시하기
		String path1 = "c:"+File.separator+"javaStudyLsh"+File.separator+"java"+File.separator+"java"+File.separator+"firstjava"+File.separator;
		System.out.println(path1);
		
		String[] files = new File(path1).list();
		System.out.println(Arrays.toString(files));
		
		//디렉 토리 filter식 작성
		
		Predicate<String> dir1 = x -> {
			File fileDir = new File(x);
			return fileDir.isDirectory();
		};
		
		Predicate<String> fileCondition = Predicate.not(dir1);
		
		List<String> dirList = Arrays.stream(files).filter(dir1).map(x-> "[디렉토리]:" + x).collect(toList());
		dirList.stream().sorted().forEach(System.out::println);
		
		List<String> fileList = Arrays.stream(files).filter(fileCondition).map(x-> {
			File f = new File(x);
			x += f.canExecute()?"\t실행파일" : "\t실행불가";
			x += f.canRead()? "\t읽기가능":"\t읽기불가";
			x += f.canWrite()?"\t쓰기가능":"\t쓰기불가";
			x += f.isHidden()?"\t숨김파일":"\t일반파일";
			return x;
		}).collect(toList());
		
		Stream.of(dirList, fileList).flatMap(List::stream).forEach(System.out::println);
		
		
		System.out.println("===================\n===================\n===================\n===================\n===================\n===================\n");
		//디렉토리 유무 : 특정 경로가 없으면 생성
		
		File p = new File(path1+"abc");
		System.out.println(p.exists());
		
		if(!p.exists()) {
			p.mkdir();
		}
		
		java.util.Scanner sc = new Scanner(System.in);
		System.out.print("생성할 파일명을 입력해주세요:");
		String fie1 = sc.next();
		fie1 = fie1+".txt";
		File f = new File(path1+"abc"+File.separator+fie1);
		
		if(!f.exists()) {
			try {
				System.out.println("존재하지 않는 파일입니다. 생성합니다.");
				f.createNewFile();
			} catch (Exception e) {	}
		}
		
		
		
		
		
		
		
		
		
	}
	
	
		
		
		
	
}
