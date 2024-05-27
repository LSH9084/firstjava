package Practice.E01;

import lombok.Data;

@Data
public class Rectangle extends Shape {
	private int height;
	private int width;
	
	public String toString() {
		return "Rectangle(width:"+width+",height:"+height+")";
	}
	
	public Rectangle(int width, int height) {
		this.width = width; this.height = height;
	}
	
	public void draw() {
		for (int i=1; i<=height; i++) {
			for(int j=1; j<=width; j++) 
				System.out.print("*");
			System.out.println();
		}
	}
}
