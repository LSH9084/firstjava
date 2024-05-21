package chap07.pra;

public class GraphicCard {
	int memory;
	
	public void process() {
		System.out.println("그래픽 처리");
	}
}

class Nvidia extends GraphicCard {
	public void process() {
		System.out.println("amd graphic process");
	}
}

