package chap09.Interface;

public class Computer {
	public static void main(String[] args) {
		GraphicCard gc = new Amd();
		
		System.out.println(gc.MEMORY);
		
		gc = new Amd();
		gc.process();
		
		gc = new Nvidia();
		gc.process();
	}
}
