package Chap11;

public class E02EnumValue {
	public static void main(String[] args) {
		FLOWER f = FLOWER.ROSE;
		System.out.printf("I have a %s \n나는 %s를 가졌다 \n", f.getNameString(),f.getName2());
		
		Days toDay = Days.SATURDAY;
		switch(toDay) {
		case SUNDAY  -> System.out.println("일요일");
		case MONDAY -> System.out.println("월요일");
		case TUESDAY -> System.out.println("화요일");
		case WENDSEDAY -> System.out.println("수요일");
		case THURSDAY -> System.out.println("목요일");
		case FRIDAY -> System.out.println("금요일");
		case SATURDAY -> System.out.println("토요일");
		default -> System.out.println("잘못 입력");
		}
		
//		System.out.println(toDay);
		
	}
}

enum FLOWER{
	SUNFLOWER("sunflower","해바라기"), ROSE("rose","장미");
	
	private final String name;
	private final String koName;
	private FLOWER(String name ,String koName) {
		this.name = name;
		this.koName = koName;
	}
	public String getNameString () {
		return name;
	}
	public String getName2() {
		return koName;
	}
}

enum Days {
	SUNDAY, MONDAY, TUESDAY, WENDSEDAY, THURSDAY, FRIDAY, SATURDAY;
}

