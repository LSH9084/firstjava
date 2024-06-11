package chap17;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class E07JOptionTest extends JFrame implements ActionListener {
	JButton btn1, btn2, btn3, btn4;
	String[] str = {"카드결제","계좌이체"};
	
	public E07JOptionTest() {
		super("여러가지 메시지 박스 테스트");
		setLayout(new FlowLayout());
		
		btn1 = new JButton("출력 메시지 박스");
		btn2 = new JButton("확인 메시지 박스");
		btn3 = new JButton("입력 메시지 박스");
		btn4 = new JButton("선택 메시지 박스");
		
		// 현재 클래스 (프레임 기능을 가진 클래스)
		add(btn1);add(btn2);add(btn3);add(btn4);
		pack();
		
		setLocation(300,300);
		setVisible(true);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		E07JOptionTest opt = new E07JOptionTest();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			JOptionPane.showMessageDialog(this, 
					//사용자에게 메시지를 보여주는 박스
						"출력 메시지 박스", // 내용
						"메시지", //창 제목
						JOptionPane.INFORMATION_MESSAGE //아이콘
					);
		} else if(e.getSource() == btn2) {
			// yes,no,cancel과 같은 버튼으로 확인하는 메시지박스
			JOptionPane.showMessageDialog(this, 
						"확인 메시지 박스",
						"확인",
						JOptionPane.YES_NO_CANCEL_OPTION
					);
		} else if(e.getSource() == btn3) {
			//사용자로부터 자료를 입력받기 위한 메시지박스 = inputdialog
			JOptionPane.showInputDialog(this, 
						"입력 메시지 박스",
						"입력",
						JOptionPane.YES_NO_OPTION
					);
		} else if(e.getSource() == btn4) {
			JOptionPane.showOptionDialog(this, 
							"선택 메시지 박스",
							"옵션",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE,
							null,
							str,
							str[0]
						);
		}
		
	}
}
