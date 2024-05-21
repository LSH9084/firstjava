package chap07;


class ElectricCar extends Car {

	public ElectricCar(String color, String manufacturer) {
		super(color, manufacturer); 
		// TODO Auto-generated constructor stub
	}

	@Override
	public String fillup() {
		
		return "전기를 충전합니다.";
	}
	
}

class GasolinCar extends Car {

	public GasolinCar(String color, String manufacturer) {
		super(color, manufacturer);
		
	}

	@Override
	public String fillup() {
		
		return "휘발유를 주유합니다.";
	}
	
}
