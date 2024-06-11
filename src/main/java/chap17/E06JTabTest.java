package chap17;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class E06JTabTest {
	JFrame jfr1;
	JTabbedPane jtab;
	ImageIcon icon1, tabicon;
	JButton btn1, btn2;
	JLabel jlab;
	JPanel jpanel;
	JTextField jtf1;
	JTextArea jtarea;
	
	public void createFrame() { //클래스 메서드를 통함 객체 생성
		// 과정
		// 객체 생성 > 각 component들을 구성
		jfr1 = new JFrame("Jtab 테스트");
		icon1 = new ImageIcon("./src/main/resources/images/bulback.jpg");
		jlab = new JLabel(icon1);
		
		tabicon = new ImageIcon("./src/main/resources/images/bulback2.jpg");
		jpanel = new JPanel();
		
		jtf1 = new JTextField("테스트");
		btn1 = new JButton("전송");
		
		jpanel.add(jtf1);
		jpanel.add(btn1);
		
		jtarea = new JTextArea(7,20);
		jtarea.setText("내용을 입력하세요");
		
		jtab = new JTabbedPane();
		jtab.addTab("탭1", jlab);
		jtab.addTab("탭2", new JPanel().add(jtarea));
		jtab.addTab("탭3", tabicon, jpanel, "세 번째 탭");
		
		jfr1.add(jtab);
		
		jfr1.setPreferredSize(new Dimension(600	,600));
		jfr1.pack();
		
		jfr1.setDefaultCloseOperation(jfr1.EXIT_ON_CLOSE);
		jfr1.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		// JTabbedPane : 탭 컴포넌트
		E06JTabTest jttt = new E06JTabTest();
		jttt.createFrame();
		
		
		
	}
	
}
