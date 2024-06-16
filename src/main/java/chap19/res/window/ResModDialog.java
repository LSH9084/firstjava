package chap19.res.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.res.controller.ResController;
import chap19.res.controller.ResControllerImpl;
import chap19.res.vo.ResVo;

public class ResModDialog extends JDialog{
	JFormattedTextField tfstart, tfend;
	JTextField tfrent_num;
	JPanel panel;
	JLabel lstart, lend,lrent_num;
	JButton btnMod;
	ResController resCon = new ResControllerImpl();
	
	public ResModDialog(ResController resC, String str) {
		this.resCon = resC;
		setTitle(str);
		
		init();
	}
	
	
	private void init() {
		tfstart = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		tfend = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		tfrent_num = new JTextField(20);
		lrent_num = new JLabel("렌트번호");
		panel = new JPanel(new GridLayout(0,2));
		lstart = new JLabel("렌트 시작일");
		lend = new JLabel("렌트 종료일");
		btnMod = new JButton("수정하기");
		btnMod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date start1 = (Date) tfstart.getValue();
				Instant start2 = start1.toInstant();
				Date end1 = (Date) tfend.getValue();
				Instant end2 = end1.toInstant();
				
				String rent_num = tfrent_num.getText().trim();
				LocalDate rent_start = start2.atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate rent_end = end2.atZone(ZoneId.systemDefault()).toLocalDate();
				
				ResVo vo2 = new ResVo(rent_num, rent_start, rent_end);
				
				
				resCon.modRes(vo2);
			}
		});
		panel.add(lrent_num);
		panel.add(tfrent_num);
		
		panel.add(lstart);
		panel.add(tfstart);
		
		panel.add(lend);
		panel.add(tfend);
		
		add(panel, BorderLayout.NORTH);
		add(btnMod, BorderLayout.SOUTH);
		
		setLocation(200,200);
		setSize(600,600);
		setModal(true);
		setVisible(true);

		
	}
	
}
