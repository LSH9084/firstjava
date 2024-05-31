package chap12.pra;

public class ProcessEx {
	public static void main(String[] args) {
		
		try {
			Process p1 = Runtime.getRuntime().exec("calc.exe");
			
			
			Process p2 = Runtime.getRuntime().exec("mspaint.exe");
			p1.waitFor();
			p2.destroy();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
