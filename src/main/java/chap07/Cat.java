package chap07;

public class Cat extends Pet {

	public Cat(boolean wing, int legCount) {
		super(wing, legCount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(String name) {
		// TODO Auto-generated method stub
		System.out.printf("%s는 소리없이 조용하게 4발로 뜁니다. \n", name);
	}
	
}

class Parrot extends Pet {

	public Parrot(boolean wing, int legCount) {
		super(wing, legCount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(String name) {
		// TODO Auto-generated method stub
		System.out.printf("%s는 힘차게 두 날개로 날아갑니다. \n",name);
	}
	
}
