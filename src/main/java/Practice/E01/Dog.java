package Practice.E01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dog extends Animal {
	String species;
	public void bark() {
		System.out.println("bowwow");
	}
	public String toString() {
		return (this.species+"의"+this.name);
	}
	public void introduce() {
		System.out.println(toString());
		bark();
	}
}
