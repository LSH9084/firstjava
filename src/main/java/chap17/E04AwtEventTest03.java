package chap17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import chap17.E02AwtEventTest.WindowHandler;

public class E04AwtEventTest03 {
	private Frame frm1;
	private Button btn1,btn2,btn3,btn4,btn5;
	public E04AwtEventTest03(){
		frm1 = new Frame("이벤트 핸들러 예제");
		btn1 = new Button("btn1");
		btn2 = new Button("btn2");
		btn3 = new Button("btn3");
		btn4 = new Button("btn4");
		btn5 = new Button("btn5");
	}
	
	public static void main(String[] args) {
		//익명 클래스
		E04AwtEventTest03 awt = new E04AwtEventTest03();
		awt.startFrame();
		
	}
	
	public void startFrame() {
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1 클릭");
				
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 2 클릭");
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 3 클릭");
			}
		});
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 4 클릭");
			}
		});
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 5 클릭");
			}
		});
		frm1.add(btn1,BorderLayout.NORTH);
		frm1.add(btn2,BorderLayout.EAST);
		frm1.add(btn3,BorderLayout.SOUTH);
		frm1.add(btn4,BorderLayout.WEST);
		frm1.add(btn5,BorderLayout.CENTER);
		
		frm1.setSize(400,400);
		
		frm1.setVisible(true);
		frm1.addWindowListener(new WindowHandler());
	}
	
	public static class WindowHandler extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("창닫기");
			System.exit(0);
		}

	}
}
