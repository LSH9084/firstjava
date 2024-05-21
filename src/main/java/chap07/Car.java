package chap07;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public abstract class Car {
	private String color;
	private String manufacturer;
	
	public void printInfo() {
		System.out.println("이 차의 색 : "+this.color+"색 || 이 차의 제조사 : "+this.manufacturer);
	}
	
	public abstract String fillup();
	
}
