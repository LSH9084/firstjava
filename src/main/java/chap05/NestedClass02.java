package chap05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
public class NestedClass02 {
	
	public static void main(String[] args) {
		NestedClass02 outer = new NestedClass02();
		outer.localMethod();
		
	}
	
	void localMethod() {
		int age = 30;
		
		class LocalClass{
			public void howOldAreYou() {
				System.out.println(age);
			}
		}
		
		LocalClass innerClass = new LocalClass();
		innerClass.howOldAreYou();
		
	}
	
}
