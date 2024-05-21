package chap04.pra;

public class ReturnEx2 {

	public static void main(String[] args) {
		Return2 obj = new Return2();
		obj.getTest(0);
		obj.getTest(1);
		System.out.println(obj.getName(0));
		System.out.println(obj.getName(1));

	}

}
class Return2 {
	void getTest(int type) {
		System.out.println("메서드시작");
		if(type==1) {
			return;
		} 
		System.out.println("메서드끝");
		
	}
	String getName(int type) {
		if(type ==1) {
			return "";
			
		}
		return "홍길동";
	}
}