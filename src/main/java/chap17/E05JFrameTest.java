package chap17;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class E05JFrameTest { //기본적인 사용법은 Frame과 거의 99프로 유사하나 연결이 더 유연한 Frame이다
	
	JFrame jfrm1 = new JFrame("JFrame 예제");
	JButton btn1, btn2, btn3, btn4;
	JTextField jtf1;
	
	public void createJFrame() { //클래스 네 메서드를 통함 객체 생성을 하고있다.
		btn1 = new JButton("btn1");
		btn2 = new JButton("btn2");
		btn3 = new JButton("btn3");
		btn4 = new JButton("btn4");
		jtf1 = new JTextField("내용을 입력하세요. ");
		
		jfrm1.add(jtf1, BorderLayout.NORTH);
		jfrm1.add(btn1, BorderLayout.SOUTH);
		jfrm1.add(btn2, BorderLayout.WEST);
		jfrm1.add(btn3, BorderLayout.EAST);
		jfrm1.add(btn4, BorderLayout.CENTER);
		
		jfrm1.setPreferredSize(new Dimension(500,500));
		jfrm1.pack();
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm1.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// AWT: 운영체제에 따라 모양이 달라 보임
		// JFC(Java Foundation Class) 라이브러리를 제공하여 운영체제 관계없이 동일 모양
		// javax.* 확장자
		
		E05JFrameTest jfrm = new E05JFrameTest();
		jfrm.createJFrame();
		
	}
}
