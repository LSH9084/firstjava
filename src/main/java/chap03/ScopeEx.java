package chap03;

public class ScopeEx {
	int no;
	public static void main(String[] args) {
		String name;
		if(true) {
			name = "홍길동";
			String email = "hong@test.com";
		}
		
//		email = "hong@test.com"; 같은 블럭단위로만 변수사용가능 
	}

}
