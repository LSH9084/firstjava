package Practice.E01;

import lombok.Data;

@Data
public abstract class AbstLine extends Shape{
	private int length;
	
	public AbstLine(int length) {
		setLength(length);
	}
	public int getLength() {
		return length;
	}
	
	public String toString() {
		return "AbstLine(length:" + length + ")";
	}
	
	public void setLength(int length) {
		this.length = length;
	}
}
