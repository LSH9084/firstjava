package chap18.model;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class E03MovieModel {

	//추가
	public void addTitle(String title, List movieList) {
		movieList.add(title);
		System.out.println("추가 성공");
		
	}
	
	//저장
	public void saveTitle(List movieList) {
		File file = new File("./src/main/resources/movieInfo.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			PrintWriter pw = new PrintWriter(bw,true);
			
			String items[] = movieList.getItems();
			Arrays.stream(items).forEach(v->{
				pw.println(v);
				System.out.println(v);
			});
			bw.close();
			pw.close();
			
			
			
		} catch (Exception e) {}
		System.out.println("저장 성공");
	}
	
	//삭제
	public void delTitle(String title, List movieList) {
		movieList.remove(title);
		System.out.println("삭제 성공");
	}
	
}
