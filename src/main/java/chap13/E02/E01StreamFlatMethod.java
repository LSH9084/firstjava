package chap13.E02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E01StreamFlatMethod {
	
	
	
	
	
	
	public static void main(String[] args) {
		
		List<String> jobCheck = Arrays.asList(
				"출근","출근","지각","출근","출근",
				"출근","출근","지각","출근","출근",
				"출근","출근","지각","출근","출근",
				"출근","출근","지각","출근","출근"
				);
		
		System.out.println(jobCheck);
		
		Map<String, Long> info = jobCheck.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(info);
		
		Map<Boolean, List<String>> result1 = jobCheck.stream().collect(Collectors.partitioningBy(s->{
			return(s.contains("출근")? true:false);
		}));  
		System.out.println(result1);
		
		

		
	}
	
	
			
}
