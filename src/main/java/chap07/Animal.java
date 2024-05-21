package chap07;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Animal {
	private int Legs ;
	private String speed ;
	
	public void prinInfo() {
		System.out.println(this.speed +"하게"+this.Legs +"로 달림");
	}
	
	public abstract String fillup();
	
	public static void main(String[] args) {
		Pet cat = new Cat(false,4);
		cat.run("고양이");
		
		Pet par = new Parrot(true, 2);
		par.run("앵무새");
		cat.run(getPetName(cat));
	}
	public static String getPetName(Pet pet) {
		String str = "";
		if(pet instanceof Cat) {
			str = "고양이";
		} else if (pet instanceof Parrot) {
			str = "앵무새";
		}
		return str;
	}
}
