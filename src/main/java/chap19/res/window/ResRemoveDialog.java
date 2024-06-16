package chap19.res.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.res.controller.ResController;
import chap19.res.controller.ResControllerImpl;
import chap19.res.vo.ResVo;

public class ResRemoveDialog extends JDialog{
	JPanel panel;
	JLabel lrent_num;
	JTextField tfrent_num;
	JButton btnRem;
	ResController resCon = new ResControllerImpl();
	
	public ResRemoveDialog(ResController resC, String str) {
		this.resCon = resC;
		setTitle(str);
		init();
	}
	
	private void init() {
		panel = new JPanel();
		lrent_num = new JLabel("렌트번호");
		tfrent_num = new JTextField(20);
		btnRem = new JButton("삭제하기");
		
		btnRem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ResVo vo2 = new ResVo();
				String rent_num = tfrent_num.getText().trim();
				
				vo2.setRent_num(rent_num);
				resCon.remRes(vo2);
				
			}
		});
		
		
		panel.add(lrent_num);
		panel.add(tfrent_num);
		
		add(panel,BorderLayout.NORTH);
		add(btnRem,BorderLayout.SOUTH);
		
		setLocation(200,200);
		setSize(600,600);
		setModal(true);
		setVisible(true);
		
	}
}
