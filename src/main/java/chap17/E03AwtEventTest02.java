package chap17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chap17.E02AwtEventTest.WindowHandler;

public class E03AwtEventTest02 {
	private Frame frm1;
	private Button btn1,btn2,btn3,btn4,btn5;
	
	public E03AwtEventTest02() { // 객체내 생성자를 통해서 컴포넌트 객체 생성
		frm1 = new Frame("이벤트 핸들러 예제");
		btn1 = new Button("btn1");
		btn2 = new Button("btn2");
		btn3 = new Button("btn3");
		btn4 = new Button("btn4");
		btn5 = new Button("btn5");
	}
	
	public void starFrame() { //객체 생성 후 객체 내 메서드를 통해서 컴포넌트 구성, 구현
		btn1.addActionListener(new InnerHandler());
		btn2.addActionListener(new InnerHandler());
		btn3.addActionListener(new InnerHandler());
		btn4.addActionListener(new InnerHandler());
		btn5.addActionListener(new InnerHandler());
		frm1.add(btn1,BorderLayout.NORTH);
		frm1.add(btn2,BorderLayout.EAST);
		frm1.add(btn3,BorderLayout.SOUTH);
		frm1.add(btn4,BorderLayout.WEST);
		frm1.add(btn5,BorderLayout.CENTER);
		
		frm1.setSize(400,400);
		
		frm1.setVisible(true);
		frm1.addWindowListener(new WindowHandler());
	}
	
	public class InnerHandler implements ActionListener{ //interface ActionListener를 통해서 구현

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn1) {
				System.out.println("btn1클릭");
				System.out.println(e.getActionCommand());
			} else if(e.getSource() == btn2) {
				System.out.println("btn2클릭");
				System.out.println(e.getActionCommand());
			} else if(e.getSource() == btn3) {
				System.out.println("btn3클릭");
				System.out.println(e.getActionCommand());
			} else if(e.getSource() == btn4) {
				System.out.println("btn4클릭");
				System.out.println(e.getActionCommand());
			} else if(e.getSource() == btn5) {
				System.out.println("btn5클릭");
				System.out.println(e.getActionCommand());
			}
		}
		
	}
	
	public static void main(String[] args) {
		//내부 클래스로 이벤트 구현
		E03AwtEventTest02 awt1 = new E03AwtEventTest02();
		awt1.starFrame();
	}
	
	
}
