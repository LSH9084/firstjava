package chap17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class E01BoardLayoutTest {
		
	public static void main(String[] args) {
		
		//boardlayout 
		/**
		 *  Object -> Component, MenuComponent -> MenuItem, MenuBar
		 *  Container -> Window, Panel
		 *  Window -> Frame, Dialog
		 *  Panel -> Applet
		 *  button 등등 이런 vscode태그들 같은것들
		 *  
		 */
		
		Frame frm;
		Button center, west, east, north, south;
		TextField tf1;
		
		frm	 	= new Frame("BoarderLayout 예제");
		south 	= new Button("btn1");
		west 		= new Button("btn2");
		east 		= new Button("btn3");
		north 	= new Button("btn4");
		center 	= new Button("btn5");
		tf1 		= new TextField("입력창 입니다.");
		
		frm.add(tf1, BorderLayout.NORTH);
		frm.add(south, BorderLayout.SOUTH);
		frm.add(west, BorderLayout.WEST);
		frm.add(east, BorderLayout.EAST);
		frm.add(center , BorderLayout.CENTER);
		
		frm.setSize(400,400);
		frm.setVisible(false);
		
		System.out.println("=== FlowLayout");
		
		Frame frm2;
		Button btn1, btn2, btn3;
		
		frm2 = new Frame("FlowLayout 예제");
		btn1 		= new Button("Ok");
		btn2		= new Button("Open");
		btn3		= new Button("Close");
		
		frm2.setLayout(new FlowLayout());
		frm2.add(btn1);
		frm2.add(btn2);
		frm2.add(btn3);
		
		frm2.setSize(500,500);
		frm2.setVisible(false);
		
		System.out.println("== GridLayout 예문");
		
		Frame frm3;
		Button btn4, btn5, btn6;
		TextField tf01, tf02, tf03;
		
		frm3 = new Frame("Grid예제");
		btn4 = new Button("btn4");
		btn5 = new Button("btn5");
		btn6 = new Button("btn6");
		
		tf01 = new TextField("입력창1");
		tf02 = new TextField("입력창2");
		tf03 = new TextField("입력창3");
		
		frm3.setLayout(new GridLayout(3,0));
		frm3.add(btn4);
		frm3.add(tf01);
		frm3.add(btn5);
		frm3.add(tf02);
		frm3.add(btn6);
		frm3.add(tf03);
		
		frm3.pack();
		frm3.setVisible(false);
		
		Frame frm4;
		TextField txt;
		Button btnOk ,btnCancel;
		Panel panel;
		frm4 = new Frame("panel 예제");
		btnOk = new Button("Ok");
		btnCancel = new Button("Cancel");
		txt = new TextField("입력창");
		
		panel = new Panel();
		
		frm4.add(txt,BorderLayout.NORTH);
		panel.setBackground(Color.green);
		panel.add(btnOk);
		panel.add(btnCancel);
		
		
		frm4.addWindowListener(new WindowHandler());
		frm4.add(panel, BorderLayout.CENTER);
		frm4.setSize(400,400);
		frm4.setVisible(true);
		
		
		
	}
	
public static class WindowHandler extends WindowAdapter{
		
	@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("==");
			System.exit(0);
		}
	}
}
