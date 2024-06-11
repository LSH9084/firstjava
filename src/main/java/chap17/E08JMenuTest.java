package chap17;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class E08JMenuTest {
		JFrame fr1;
		JMenuBar menuBar;
		JMenu carMenu, memberMenu, rentMenu, helpMenu;
		JMenuItem rentMenu41, rentMenu42, rentMenu43, rentMenu44;
		JMenuItem carMenu11, carMenu12, carMenu13, carMenu14;
		JMenuItem memMenu21, memMenu22, memMenu23, memMenu24;
		JMenuItem helpMenu31;
		
		JPanel panel;
		JLabel label;
		
		JTextField txt;
		JButton searchBtn;
		
		E08JMenuTest(){ //클래스 내 생성자를 통한 객체 생성
			fr1 = new JFrame("렌터카 예약 시스템");
			menuBar = new JMenuBar();
			
			carMenu = new JMenu("차량 관리");
			memberMenu = new JMenu("회원 관리");
			rentMenu = new JMenu("예약 관리");
			helpMenu = new JMenu("도움말");
			
//			carMenu11 = new JMenuItem();
			
			
		}
		public void createFrame() {
			fr1.setJMenuBar(menuBar);
			menuBar.add(carMenu);
			carMenu.add(carMenu11 = new JMenuItem("차량등록"));
			carMenu.add(carMenu12 = new JMenuItem("차량조회"));
			carMenu.addSeparator();
			carMenu.add(carMenu13 = new JMenuItem("차량수정"));
			carMenu.add(carMenu14 = new JMenuItem("차량삭제"));
			
			menuBar.add(memberMenu);
			memberMenu.add(memMenu21 = new JMenuItem("회원등록"));
			memberMenu.add(memMenu22 = new JMenuItem("회원조회"));
			memberMenu.addSeparator();
			memberMenu.add(memMenu23 = new JMenuItem("회원수정"));
			memberMenu.add(memMenu24 = new JMenuItem("회원삭제"));
			
			menuBar.add(helpMenu);
			helpMenu.add(helpMenu31 = new JMenuItem("버전"));
			
			menuBar.add(rentMenu);
			rentMenu.add(rentMenu41 = new JMenuItem("렌트 등록"));
			rentMenu.add(rentMenu42 = new JMenuItem("렌트 조회"));
			rentMenu.addSeparator();
			rentMenu.add(rentMenu43 = new JMenuItem("렌트 수정"));
			rentMenu.add(rentMenu44 = new JMenuItem("렌트 삭제"));
			
			panel = new JPanel();
			label = new JLabel("차량명");
			
			txt = new JTextField(10);
			searchBtn = new JButton("차량 조회하기");
			
			panel.add(label);
			panel.add(txt);
			panel.add(searchBtn);
			
			Container con = fr1.getContentPane();
			con.add(panel, BorderLayout.NORTH);
			
			fr1.setLocation(200,100);
			fr1.setSize(new Dimension(600,400));
			fr1.setVisible(true);
			fr1.setDefaultCloseOperation(fr1.EXIT_ON_CLOSE);
			
			
		}
	
	
		public static void main(String[] args) {
			// JMenuBar -> JMenu -> JMenuItem
			E08JMenuTest te = new E08JMenuTest();
			te.createFrame();
			
			
		}
}
