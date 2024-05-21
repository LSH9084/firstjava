package chap07;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public abstract class Pet {
	private boolean wing;
	private int legCount;
	
	
	public String isWing() {
		String str;
		if(this.wing) {
			str = "can fly";
		} else {
			str = "cant fly";
		}
		return str;
	}
	
	public int getLegCount() {
		return legCount;
	}
	
	public abstract void run(String name);
}
