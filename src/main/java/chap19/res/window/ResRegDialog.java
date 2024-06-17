package chap19.res.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.member.vo.MemberVo;
import chap19.rentCar.vo.CarVo;
import chap19.res.controller.ResController;
import chap19.res.controller.ResControllerImpl;
import chap19.res.vo.ResVo;

public class ResRegDialog extends JDialog{
	JPanel panel;
	JLabel lnum,lday,lstart,lend,lcar_num,lid;
	JTextField tfnum,tfday,tfstart,tfend,tfcar_num,tfid;
	JButton btnReg;
	ResController resCon = new ResControllerImpl();
	JFormattedTextField tfday2;
	JFormattedTextField tfstart2;
	JFormattedTextField tfend2;
	
	public ResRegDialog(ResController resC, String str) {
		this.resCon = resC;
		setTitle(str);
		
		init();
		
	}
	
	private void init() {
		lnum = new JLabel("렌트번호");
		lday = new JLabel("예약날짜");
		lstart = new JLabel("시작일");
		lend = new JLabel("반납일");
		lcar_num = new JLabel("차량번호");
		lid = new JLabel("아이디");
		tfday2 = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		tfstart2 = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		tfend2 = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		
		
		
		tfnum = new JTextField(21);
		tfday = new JTextField(21);
		tfstart = new JTextField(21);
		tfend = new JTextField(21);
		tfcar_num = new JTextField(21);
		tfid = new JTextField(21);
		
		btnReg = new JButton("등록하기");
		btnReg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				java.util.Date date = (java.util.Date) tfday2.getValue();
				Instant instant = date.toInstant();
				java.util.Date date2 = (java.util.Date) tfstart2.getValue();
				Instant instant2 = date2.toInstant();
				java.util.Date date3 = (java.util.Date) tfend2.getValue();
				Instant instant3 = date3.toInstant();
				

				
//				String dateString = tfday.getText().trim();
				String rent_num = tfnum.getText().trim();
				LocalDate rent_day =  instant.atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate rent_start =  instant2.atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate rent_end =  instant3.atZone(ZoneId.systemDefault()).toLocalDate();
				String rent_car_num = tfcar_num.getText().trim();
				String rent_id = tfid.getText().trim();
				
				
				ResVo vo2 = new ResVo(rent_num, rent_day, rent_start, rent_end, rent_car_num, rent_id);
//				resCon.regRes(vo2);
				
				Optional<ResVo> checkIdVo = Optional.ofNullable(resCon.checkId3(rent_id));
				
				if(checkIdVo.get().getRent_num() != null) {
					message("사용중인 렌트 번호입니다.");
				} else {
					int result = resCon.regRes(vo2);
					if(result >0) {
						message("렌트카 등록을 완료했습니다.");
						
					} else {
						message("렌트카 등록을 실패했습니다.");
					}
				}
				
				
				
			}
		});
		
		panel = new JPanel(new GridLayout(0,2));
		panel.add(lnum);
		panel.add(tfnum);
		
		panel.add(lday);
//		panel.add(tfday);
		panel.add(tfday2);
		
		panel.add(lstart);
//		panel.add(tfstart);
		panel.add(tfstart2);
		
		panel.add(lend);
//		panel.add(tfend);
		panel.add(tfend2);
		
		panel.add(lcar_num);
		panel.add(tfcar_num);
		
		panel.add(lid);
		panel.add(tfid);
		
		add(panel, BorderLayout.NORTH);
		add(btnReg, BorderLayout.SOUTH);
		
		setLocation(200,200);
		setSize(600,600);
		setModal(true);
		setVisible(true);
		
	}
	
	private void message (String str) {
		JOptionPane.showMessageDialog(this, str,"안내창",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
