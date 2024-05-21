package chap04.pra;

public class Car2 {
	String color;
	String company;
	String type;
	
	Car2(){
		this("화이트","기아","경차");
	}
	
	Car2(String color, String company, String type){
		this.color = color;
		this.company = company;
		this.type = type;
	}
	
	Car2(String com, String t){
		this("화이트",com,t);
	}
	
	Car2(String t){
		this("화이트","기아",t);
	}
	
	public String toString() {
		return color + "-" + company + "-" + type;
	}
}

