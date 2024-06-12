package chap18;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import chap18.controller.E02MovieController;

public class E01MovieView extends JFrame implements ActionListener{
	String resultMsg = null;
	
	JTextField tMovieTitle;
	JButton btnTitleInsert, btnSave, btnExit;
	List movieList;
	E02MovieController controller = new E02MovieController();
	
//	MovieController controller;
	
	public E01MovieView() {
		//컴포넌트 객체 생성
		super("영화 정보 관리 화면");

		tMovieTitle = new JTextField(30);
		btnTitleInsert = new JButton("영화 제목 추가");
		btnSave = new JButton("영화제목 파일 저장");
		
		movieList = new List();
		
		btnExit = new JButton("종료");
		
		//컴포넌트 설정
		movieList.setBackground(Color.green);

		
		Panel p = new Panel();
		p.add(new JLabel("영화제목 입력"));
		p.add(tMovieTitle);
		p.add(btnTitleInsert);
		p.add(btnSave);
		
		add(BorderLayout.NORTH, p);
		add(BorderLayout.CENTER,movieList);
		add(BorderLayout.SOUTH, btnExit);
		
		setBounds(0,0,800,600);
		setVisible(true);
		setDefaultCloseOperation(super.EXIT_ON_CLOSE);
		btnExit.addActionListener(this);
		movieList.addActionListener(this);
		btnTitleInsert.addActionListener(this);
		btnSave.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
	/** MVC디자인 패턴
	 * 
	 * 뷰(view) : 사용자의 요청을 받아들이는 화면으로 요청을 컨트롤러로 전달
	 * 컨트롤(Controller) : View에서 전달된 요청에 맞는 모델을 선택
	 * 모델(Model) : 데이터베이스 연동이나 파일 저장, 로직등 실제 기능을 수행
	 * 
	 */
		E01MovieView te = new E01MovieView();		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String mTitle = e.getActionCommand();
			if(e.getSource() == btnTitleInsert) {
				resultMsg ="영화제목을 추가했습니다.";
				
				//텍스트에 입력한 영화제목
				mTitle =  tMovieTitle.getText().trim();
				controller.addTitle(mTitle, movieList);
				tMovieTitle.setText("");
				
			} else if (e.getSource() == btnSave) {
				resultMsg = "영화 제목을 파일에 저장했습니다.";
				controller.saveTitle(movieList);
			} else  if(e.getSource() == movieList){
				resultMsg = "영화제목을 삭제했습니다.";
				controller.delTitle(mTitle, movieList);
			}
			if(e.getSource() == btnExit) {
				System.exit(1); //정상 종료 (0): 비정상 종료
			}
			JOptionPane.showMessageDialog(this, resultMsg,"메시지박스",JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e2) {}
	}
}
