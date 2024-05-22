package chap08;

public class InterfaceClass01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICompute a = new Apartment();
		float area = a.compute(30);
		System.out.printf("아파트의 면적은 %f 제곱미터입니다.\n",a.compute(30));
		
		float areaa = a.toPyung(area);
		System.out.println(areaa);
	}

}

interface ICompute {
	static final float PYUNG = 3.3f;
	static final double PI = 3.141597;
	
	float compute(int area);
	
	default float toPyung(float area) {
		return area  / PYUNG ;
	}
}

class Apartment implements ICompute {

	@Override
	public float compute(int area) {
		return area * PYUNG;
		
	}
	
}