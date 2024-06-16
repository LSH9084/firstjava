package chap19.rentCar.window;

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
import chap19.rentCar.controller.CarController;
import chap19.rentCar.vo.CarVo;

public class RegCarDialog extends JDialog {
	CarController CarCon;
	JPanel panel;
	JLabel lcar_num,lcar_name,lcar_color,lcar_size,lcar_made;
	JTextField tfcar_num, tfcar_name, tfcar_color, tfcar_size, tfcar_made;
	JButton btnReg;
	
	public RegCarDialog(CarController memC, String str) {
		this.CarCon = memC;
		
		setTitle(str);
		init();
	}
	
	private void init() {
		lcar_num = new JLabel("차량 번호");
		lcar_name = new JLabel("차량 이름");
		lcar_color = new JLabel("차량 색상");
		lcar_size = new JLabel("배기량");
		lcar_made = new JLabel("제작사");
		
		tfcar_num = new JTextField(20);
		tfcar_name = new JTextField(20);
		tfcar_color = new JTextField(20);
		tfcar_size = new JTextField(20);
		tfcar_made = new JTextField(20);
		
		btnReg = new JButton("차량 등록하기");
		btnReg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String car_num = tfcar_num.getText().trim();
				String car_name = tfcar_name.getText().trim();
				String car_color = tfcar_color.getText().trim();
				int car_size = Integer.parseInt(tfcar_size.getText().trim());
				String car_made = tfcar_made.getText().trim();
				
				CarVo vo = new CarVo(car_num,car_name,car_color,car_size,car_made);
				Optional<CarVo> checkIdVo = Optional.ofNullable(CarCon.checkId2(car_num));
				
				if (checkIdVo.get().getCar_num() != null) {
					showMessage(checkIdVo.get().getCar_num(),-1);
				} else {
					try {
						int result;
						result = CarCon.regCar(vo);
						if(result>0) {
							showMessage("새 차량을 등록했습니다.",result);
							tfcar_color.setText("");
							tfcar_made.setText("");
							tfcar_name.setText("");
							tfcar_num.setText("");
							tfcar_size.setText("");
						} else {
							showMessage("차량 등록 실패",result);
						}
						} catch (Exception e1) {
							e1.getMessage();
						}
				}
				
				
				
				
				
			}
			
		});
		
		panel = new JPanel(new GridLayout(0,2));
		panel.add(lcar_num);
		panel.add(tfcar_num);
		
		panel.add(lcar_name);
		panel.add(tfcar_name);
		
		panel.add(lcar_color);
		panel.add(tfcar_color);
		
		panel.add(lcar_size);
		panel.add(tfcar_size);
		
		panel.add(lcar_made);
		panel.add(tfcar_made);
		
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
