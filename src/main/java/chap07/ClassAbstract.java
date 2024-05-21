package chap07;

public class ClassAbstract {
	public static void main(String[] args) {
		ElectricCar el1 = new ElectricCar("검정", "벤츠");
		ElectricCar el2 = new ElectricCar("검정", "벤츠");
		GasolinCar el3 = new GasolinCar("하양", "bmw");
		el1.printInfo();
		
		System.out.println(el1.fillup());
		System.out.println(el3.fillup());
		System.out.println(el2);
		
		
	}
}

