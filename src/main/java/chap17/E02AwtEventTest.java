package chap17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class E02AwtEventTest implements ActionListener {
	
	private Frame frm1;
	private Button btn1,btn2,btn3,btn4,btn5;
	
	public E02AwtEventTest() {
		frm1 = new Frame("이벤트 핸들러 예제");
		btn1 = new Button("btn1");
		btn2 = new Button("btn2");
		btn3 = new Button("btn3");
		btn4 = new Button("btn4");
		btn5 = new Button("btn5");
	}
	
	
	public static void main(String[] args) {
		
		/*
		 *  이벤트 소스 : 이벤트를 발생시킨 컴포넌트(button,....)
		 *  이벤트 리스너 : 이벤트 소스가 발생시키는 이벤트를 처리할 수 있는 구현 클래스가 구현할 인터페이스
		 *  이벤트 핸들러 : 이벤트 리스너를 구현한 이벤트를 처리하는 클래스
		 */	
		
		E02AwtEventTest awt = new E02AwtEventTest();
		awt.starFrame();
		
	}
	
	public void starFrame() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		frm1.add(btn1,BorderLayout.NORTH);
		frm1.add(btn2,BorderLayout.EAST);
		frm1.add(btn3,BorderLayout.SOUTH);
		frm1.add(btn4,BorderLayout.WEST);
		frm1.add(btn5,BorderLayout.CENTER);
		
		frm1.setSize(400,400);
		
		frm1.setVisible(true);
		frm1.addWindowListener(new WindowHandler());
	}


	@Override
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
	
	public static class WindowHandler extends WindowAdapter{
		
		@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("==");
				System.exit(0);
			}
	}
}
