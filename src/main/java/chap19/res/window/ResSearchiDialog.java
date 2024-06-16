package chap19.res.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import chap19.common.RentTableModel;
import chap19.res.controller.ResController;
import chap19.res.controller.ResControllerImpl;
import chap19.res.vo.ResVo;

public class ResSearchiDialog extends JDialog {
	JTable table;
	JLabel lrent_start,lrent_end;
//	JTextField tfrent_num;
	JFormattedTextField tfrent_start, tfrent_end;
	JButton btnSearch, btnMod,btnReg,btnDel;
	JPanel pBtn, pl;
	Object [][] memItems = new String[0][6]; 
	String[] columnNames = {
			"렌트번호","예약날짜","시작일","종료일","차량번호","회원아이디"
	};
	
	int row =0, col=0;
	
	ResController resCon = new ResControllerImpl();
	RentTableModel rm;
	
	public ResSearchiDialog(ResController resC, String str) {
		this.resCon = resC;
		setTitle(str);
		init();
	}
	
	private void init() {
		table = new JTable();
		rm = new RentTableModel(memItems,columnNames);
		lrent_start = new JLabel("시작일");
		tfrent_start = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		lrent_end = new JLabel("종료일");
		tfrent_end = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		btnSearch = new JButton("조회하기");
		btnMod = new JButton("수정");
		btnReg = new JButton("등록");
		btnDel = new JButton("삭제");
		
		pl = new JPanel(new GridLayout());
		pBtn = new JPanel();
		
		pl.add(lrent_start);
		pl.add(tfrent_start);
		pl.add(lrent_end);
		pl.add(tfrent_end);
		pl.add(btnSearch);
		
		pBtn.add(btnReg);
		pBtn.add(btnMod);
		pBtn.add(btnDel);
		
		btnSearch.addActionListener(new MemBtnHandler());
		
		add(pl,BorderLayout.NORTH);
		add(new JScrollPane(table),BorderLayout.CENTER);
		add(pBtn,BorderLayout.SOUTH);
		
		setLocation(300,100);
		setSize(800,600);
		setModal(true);
		setVisible(true);
		
	}
	
	class MemBtnHandler implements ActionListener{
		List<ResVo> resList = null;
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnSearch) {
				Date start1 = (Date) tfrent_start.getValue();
				Date end1 = (Date) tfrent_end.getValue();
				
				if (start1 == null || end1 == null) {
	                System.out.println("Start date or end date is empty");
	                return;
	            }
				
				Instant start2 = start1.toInstant();
				Instant end2 = end1.toInstant();
				
				LocalDate rent_start = start2.atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate rent_end = end2.atZone(ZoneId.systemDefault()).toLocalDate();
				
				resList = new ArrayList<ResVo>();
				ResVo vo2 = new ResVo();
//				vo2.setRent_start(rent_start);
//	            vo2.setRent_end(rent_end);
//	            resList = resCon.searchRes(vo2);
//	            loadTableData(resList);
//	            resList.stream().forEach(System.out::println);
				
				if(rent_start != null && rent_end !=null) {
					vo2.setRent_start(rent_start);
					vo2.setRent_end(rent_end);
					
					resList = resCon.searchRes(vo2);
					loadTableData(resList);
					resList.stream().forEach(System.out::println);
				}
				
				
			}
			
		}
		private void loadTableData (List<ResVo> resList) {
			if(resList!=null && !resList.isEmpty()) {
//				List<ResVo> list1 = new ArrayList<ResVo>();
				memItems = new String [resList.size()][6]; //리스트의 개수만큼 행을 설정
				for (int i =0; i<resList.size(); i++) {
					ResVo resVo = resList.get(i);
					memItems[i][0] = resVo.getRent_num();
					memItems[i][1] = resVo.getRent_day() != null ? resVo.getRent_day().toString() : "";
			        memItems[i][2] = resVo.getRent_start() != null ? resVo.getRent_start().toString() : "";
			        memItems[i][3] = resVo.getRent_end() != null ? resVo.getRent_end().toString() : "";
					memItems[i][4] = resVo.getRent_car_num();
					memItems[i][5] = resVo.getRent_id();
				}
				//테이블 데이터 모델 설정
				rm = new RentTableModel(memItems, columnNames);
				//테이블 UI view에 테이블 데이터 모델 설정
				table.setModel(rm);
				
			} else {
//				message("조회한 정보가 없습니다.");
				memItems = new Object[0][6];
				rm = new RentTableModel(memItems, columnNames);
				table.setModel(rm);
			}
		}
	}
}
