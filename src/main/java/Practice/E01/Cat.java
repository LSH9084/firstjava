package Practice.E01;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Cat extends Animal {
	int age;
	public void bark() {
		System.out.println("야옹");
	}
	public String toString() {
		return (this.age+"의"+this.name);
	}
	public void introduce() {
		System.out.println(toString());
		bark();
	}
}
