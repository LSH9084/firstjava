package chap07;

public class FourLegs extends Animal {

	public FourLegs(int Legs, String speed) {
		super(Legs, speed);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String fillup() {
		
		return "발이 4개인 동물";
	}

}

class TwoLegs extends Animal {

	public TwoLegs(int Legs, String speed) {
		super(Legs, speed);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String fillup() {

		return "발이 2개인 동물";
	}
	
}
