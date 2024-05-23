package chap10.pra;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circle extends Shape{
	double r;
	
	Circle(){
		this(1);
	}
	
	public double length() {
		return (r*2)*Math.PI;
	}
	
	public double area() {
		return (r*r)*Math.PI;
	}
}
