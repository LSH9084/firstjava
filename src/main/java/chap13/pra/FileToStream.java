package chap13.pra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileToStream {
	public static void main(String[] args) {
		
		
		try {
			Path path = Paths.get("src/chap13/pra/CollectionToStream.java");
			Stream<String> stm1 = Files.lines(path, Charset.defaultCharset());
			stm1.forEach(System.out::println);
			stm1.close();
			System.out.println();
			
			File file = path.toFile();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			br.lines().forEach(System.out::println);
			stm1.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
