package Practice.E01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Animal {
	String name;
	abstract public void bark();
	
	abstract void introduce();
}
