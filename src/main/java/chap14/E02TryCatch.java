package chap14;

public class E02TryCatch {
	public static void main(String[] args) {
		
		//throw : 강제로 오류를 발생
		try {
			System.out.println("throw 객체로 인위적으로 오류를 발생시키기");
			throw new UnsupportedOperationException("throw로 오류를 강제로 발생(1)"); 
		} catch (Exception e) {
			System.out.println(e.getMessage()+"");
			// TODO: handle exception
		}
		System.out.println("====throws 오류를 위임: 상위 영역으로 떠넘기기====");
		try {
			excute();
			excute2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("정상 처리 되었습니다.");
		
		
		
		
	}
	public static void excute() throws Exception{
		
		System.out.println(30/0);
//		throw new Exception("throws 로 오류를 강제로 위임시킴!!!"); 
	}
	public static void excute2() throws Exception{
		
//		System.out.println(30/0);
		throw new Exception("throws 로 오류를 강제로 위임시킴!!!"); 
	}
}
