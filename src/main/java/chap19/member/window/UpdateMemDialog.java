package chap19.member.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.member.controller.MemberController;
import chap19.member.controller.MemberControllerImpl;
import chap19.member.vo.MemberVo;

public class UpdateMemDialog extends JDialog {
	MemberController memCon;
	JLabel lId,lPs,lName,lAddress,lP_num;
	JTextField tfId,tfPs,tfName,tfAddress,tfP_num;
	JButton btnUpd;
	JPanel panel;
	
	public UpdateMemDialog(MemberController memC, String str) {
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
		
		btnUpd = new JButton("회원 정보 수정");
		btnUpd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원 정보 수정");
				
				String id = tfId.getText().trim();
				String ps = tfPs.getText().trim();
				String name = tfName.getText().trim();
				String address = tfAddress.getText().trim();
				String phoneNum = tfP_num.getText().trim();
				
				MemberVo vo = new MemberVo(id,ps,name,address,phoneNum);
				memCon.modMember(vo);
				
			}
		});
		
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
		add(btnUpd, BorderLayout.SOUTH);
		
		setLocation(200,200);
		setSize(600,600);
		setModal(true);
		setVisible(true);
	}
	
}
