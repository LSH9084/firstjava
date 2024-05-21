package chap07.pra;

public class Computer {
	public static void main(String[] args) {
		
		GraphicCard gc = new GraphicCard();
		gc.process();
		
		gc = new Nvidia();
		gc.process();
	}
}
