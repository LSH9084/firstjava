package chap17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class E12UserTableModelTest extends JFrame {
	JPanel searchPanel;
	JPanel bPanel;
	
	JList memberJList;
	JLabel iCondition;
	
	JTextField tCondition;
	JButton searchBtn;
	JComboBox combo;
	
	JTable memTable;
	
	JButton updateBtn, deleteBtn;
	Object[] [] emp = new Object[0][4];
	
	E12UserTableModelTest() {
		initTableModelTest();
		
		setTitle("사용자 정의 테이블 실습");
		setLayout(new BorderLayout());
		
		Container c = getContentPane() ;
		c.add(searchPanel, "North");
		
		c.add(new JScrollPane(memTable), "Center");
		c.add(bPanel,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,200);
		pack();
		
		setVisible(true);
	}
	
	
	private void initTableModelTest() { //생성자를 통해 메서드를 호출하고 메서드에서 객체 생성을 통해 컴포넌트 구성
		//화면 요소 구성하기
		searchPanel = new JPanel();
		tCondition = new JTextField("10");
		iCondition = new JLabel("입력창");
		
		memberJList = new JList();
		memberJList.setBackground(Color.GREEN);
		
		memTable = new JTable();
		memTable.setModel(new E11UserTableModel(emp));
		
		searchBtn = new JButton("조회하기");
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[][] data = {
						{"220000","박길동","총무부"},
						{"220001","홍길동","관리부"},
						{"220002","이순신","회계부"},
						{"220003","임꺽정","개발부"},
						{"220004","강감찬","관리부"},
						{"220005","제임스","총무부"}
				};
				
				memTable.setModel(new E11UserTableModel(data));
				
			}
		});
		
		searchPanel.add(iCondition);
		searchPanel.add(tCondition);
		searchPanel.add(searchBtn);
		
		bPanel = new JPanel();
		updateBtn = new JButton("수정하기");
		deleteBtn = new JButton("삭제하기");
		bPanel.add(updateBtn);
		bPanel.add(deleteBtn);
		
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("수정클릭");
				
			}
		});
		
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("삭제클릭");
				
			}
		});
	}

	public static void main(String[] args) {
		new E12UserTableModelTest();
		
		
	}
}


/*
 * 작성하고 완성하여 다음주 월요일 개인 포폴 사전 발표 하시오 
 * and  팀 프로젝트 주제 선정 
 */
