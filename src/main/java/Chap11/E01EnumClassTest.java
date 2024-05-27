package Chap11;

public class E01EnumClassTest {
	public static void main(String[] args) {
		Color inputColor = Color.RED;
		Size inputSize = Size.SMALL;
		System.out.println(inputColor.equals(Color.RED)? "Red":"NotRed");
		System.out.println(inputSize.equals(Size.SMALL)? "Small":"NotSmall");
		
		Color1 inputColor1 = Color1.RED;
		System.out.println(inputColor1.equals(Color1.RED)? "RED":"not");
		System.out.println(inputColor1.equals(Size1.SMALL)? "RED":"not");
		
		System.out.println("열거형반복자");
		for(Color1 c : Color1.values()) {
			System.out.println(c.name()+":"+c.ordinal());
		}
		System.out.println("==========\n"+Color1.RED);
		System.out.println(Size1.LARGE);
	}
}

class Color {
	final static Color RED = new Color( );
	final static Color BLUE = new Color( );
	final static Color GREEN = new Color( );
}

class Size {
	final static Size SMALL = new Size();
	final static Size MIDIUM = new Size();
	final static Size LARGE = new Size();
}

enum Color1 {
	RED{
		@Override
		public String toString() {
			return "빨간색";
		}
	},
	BLUE{
		@Override
		public String toString() {
			return "파란색";
		}
	},
	GREEN{
		@Override
		public String toString() {
			return "초록색";
		}
	}
}

enum Size1 {
	SMALL{
		@Override
		public String toString() {
			return "작음";
		}
	},
	LARGE{
		@Override
		public String toString() {
			return "큼";
		}
	}
	
	
}