package chap04.pra;

public class CarMain2 {

	public static void main(String[] args) {
		Car[] cars = new Car[3];
		Car tico = new Car();
		tico.color =  "화이트";
		tico.company = "대운";
		tico.type = "경차";
		
		for(int i=0; i<cars.length;i++) {
			cars[i] = tico;
		}
		System.out.println(cars[2].color);
		cars[0].color = "블랙";
		System.out.println();

	}

}
