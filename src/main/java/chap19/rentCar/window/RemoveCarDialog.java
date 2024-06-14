package chap19.rentCar.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.rentCar.controller.CarController;
import chap19.rentCar.vo.CarVo;

public class RemoveCarDialog extends JDialog {
	CarController carCon;
	JLabel lId;
	JButton btnRem;
	JTextField tfId;
	JPanel panel;
	
	public RemoveCarDialog(CarController carC,String str) {
		this.carCon = carC;
		setTitle(str);
		init();
		
	}
	
	private void init() {
		lId = new JLabel("아이디");
		tfId = new JTextField(20);
		btnRem = new JButton("제거하기");
		
		btnRem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tfId.getText().trim();
				CarVo vo = new CarVo();
				vo.setCar_num(id);
				try {
					carCon.removeCar(vo);
					showMessage("차량을 삭제했습니다.");
				} catch (Exception e1) {
					e1.getMessage();
				}
			}
		});
		
		panel = new JPanel();
		panel.add(lId);
		panel.add(tfId);
		
		add(panel,BorderLayout.NORTH);
		add(btnRem, BorderLayout.SOUTH);
		
		setLocation(200,300);
		setSize(400,400);
		setModal(true);
		setVisible(true);
	}
	
	private void showMessage(String str) {
		JOptionPane.showMessageDialog(this, str, "메시지박스",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
	

