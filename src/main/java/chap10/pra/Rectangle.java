package chap10.pra;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Rectangle extends Shape {
	int w, h;
	
	Rectangle(){
		this(1,1);
	}
	
	public double area() {
		return(w*h);
		
	}
	
	public double length() {
		return(w+h);
	}
}
