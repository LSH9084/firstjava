package chap19.member.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.member.controller.MemberController;
import chap19.member.controller.MemberControllerImpl;
import chap19.member.vo.MemberVo;

public class RemoveMemDialog extends JDialog{
	MemberController memCon;
	// 화면 구성요소 객체
	JPanel panel;
	JLabel lId, lPs ;
	JTextField tfId, tfPs;
	JButton btnRemove;
	String onId;
	String onPs;
	
	public RemoveMemDialog(MemberController memC, String str) {
		this.memCon = memC;
		init();
	}
	
	
	private void init() {
		panel = new JPanel();
		lId = new JLabel("아이디");
		lPs = new JLabel("비밀번호");
		
		tfId = new JTextField(10);
		tfPs = new JTextField(10);
		btnRemove = new JButton("삭제하기");
		
		btnRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tfId.getText().trim();
				String ps = tfPs.getText().trim();
				
				MemberVo vo = new MemberVo();
				vo.setId(id);
				vo.setPs(ps);
				System.out.println(vo);
//				List<MemberVo> list1 = new ArrayList<MemberVo>();
//				list1 = memCon.listMember(vo);]
				
				memCon.removeMember(vo);
				showMessage("삭제하였습니다.");
			}
		});
		panel = new JPanel(new GridLayout(0,2));
		panel.add(lId);
		panel.add(tfId);
		
		panel.add(lPs);
		panel.add(tfPs);
		
		add(panel,BorderLayout.NORTH);
		add(btnRemove,BorderLayout.SOUTH);
		
		setLocation(200,200);
		setSize(600,600);
		setModal(true);
		setVisible(true);
		
	}
	
	private void showMessage (String str) {
		JOptionPane.showMessageDialog(this, str,"메시지박스",JOptionPane.INFORMATION_MESSAGE);
	}
}
