package chap19.member.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.member.controller.MemberController;
import chap19.member.vo.MemberVo;

public class RegMemDialog extends JDialog {
	// 회원 정보 등록 하기 
	// 회원 정보 등록 요청 객체
	MemberController memCon;
	// 화면 구성요소 객체
	JPanel panel;
	JLabel lId, lPs, lAddress,lName, lP_num;
	JTextField tfId, tfName, tfPs, tfAddress, tfP_num;
	JButton btnReg;
	
	public RegMemDialog(MemberController memC, String str) {
		this.memCon = memC;
		
		setTitle(str);
		init();
	}
	
	private void init() {
		lId = new JLabel("아이디");
		lPs = new JLabel("비밀번호");
		lAddress = new JLabel("주소");
		lName = new JLabel("이름");
		lP_num = new JLabel("전화번호");
		
		tfId = new JTextField(20);
		tfPs = new JTextField(20);
		tfName = new JTextField(20);
		tfAddress = new JTextField(20);
		tfP_num = new JTextField(20);
		
		btnReg = new JButton("회원등록하기");
		btnReg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원등록 하기");
				//화면에 있는 값을 변수로 저장
				String id = tfId.getText().trim();
				String ps = tfPs.getText().trim();
				String name = tfName.getText().trim();
				String address = tfAddress.getText().trim();
				String phoneNum = tfP_num.getText().trim();
				
				
				MemberVo vo = new MemberVo(id,ps,name,address,phoneNum);
				//회원정보 db등록 요청
//				MemberVo checkIdVo = memCon.checkId(id);
				
				Optional<MemberVo> checkIdVO =  Optional.ofNullable(memCon.checkId(id));
				System.out.println("check id: "+checkIdVO.get().getId());
				
				if (checkIdVO.get().getId() != null) { // id가 중복 체크 아니면
					showMessage(checkIdVO.get().getId()+" 사용중인 아이디입니다.", -1);
					
				} else  { // id가 중복일 경우
					// 회원정보 db등록 요청
					int result = memCon.regMember(vo);
					if (result > 0) {
						showMessage("새 회원을 등록했습니다.",result);
						
						tfId.setText("");
						tfPs.setText("");
						tfName.setText("");
						tfAddress.setText("");
						tfP_num.setText("");
					} else {
						showMessage("회원 등록 실패", result);
					}					
				}
			} //actionperformed()
			
		}); //actionListener()
		
		panel = new JPanel(new GridLayout(0,2));
		panel.add(lId);
		panel.add(tfId);
		
		panel.add(lPs);
		panel.add(tfPs);
		
		panel.add(lName);
		panel.add(tfName);
		
		panel.add(lAddress);
		panel.add(tfAddress);
		
		panel.add(lP_num);
		panel.add(tfP_num);
		
		add(panel, BorderLayout.NORTH);
		add(btnReg, BorderLayout.SOUTH);
		
		setLocation(200,200);
		setSize(600,600);
		setModal(true);
		setVisible(true);
		
	}
	
	private void showMessage (String str ,int result) {
		System.out.println(str);
		
		if(result>0) {
			JOptionPane.showMessageDialog(this, str,"메시지박스",JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, str,"메시지박스",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	
}
