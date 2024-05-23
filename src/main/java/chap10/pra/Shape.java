package chap10.pra;

public abstract class Shape {
	int x, y;
	
	Shape(){
		this(0,0);
	}
	Shape(int x ,int y){
		this.x = x;
		this.y = y;
	}
	
	abstract double area();
	abstract double length();
	
	public String getLocation() {
		return "x:" + x + ",y:" + y;
	}
	
}
