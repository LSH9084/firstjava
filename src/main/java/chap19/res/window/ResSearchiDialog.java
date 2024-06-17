package chap19.res.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import chap19.common.RentTableModel2;
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
	RentTableModel2 rm;
	
	public ResSearchiDialog(ResController resC, String str) {
		this.resCon = resC;
		setTitle(str);
		init();
	}
	
	private void init() {
		table = new JTable();
		rm = new RentTableModel2(memItems,columnNames);
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
		btnMod.addActionListener(new MemBtnHandler());
		btnDel.addActionListener(new MemBtnHandler());
		btnReg.addActionListener(new MemBtnHandler());
		
		ListSelectionModel rowSel = table.getSelectionModel();
		rowSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ListSelectionModel colSel = table.getColumnModel().getSelectionModel();
		colSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		rowSel.addListSelectionListener(new ListRowSel());
		colSel.addListSelectionListener(new ListColSel());
		
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
			String rent_num = null;
			LocalDate rent_day1 = null;
			LocalDate rent_start1 = null;
			LocalDate rent_end1 = null;
			String rent_car_num = null;
			String rent_id = null;
			
			ResVo vo1 = ResVo.builder()
					.rent_num(rent_num)
					.rent_day(rent_day1)
					.rent_start(rent_start1)
					.rent_end(rent_end1)
					.rent_car_num(rent_car_num)
					.rent_id(rent_id)
					.build();
			
			List<ResVo> resList = null;
			if(e.getSource()==btnSearch) {

				 String rent_start = tfrent_start.getText();
	             String rent_end = tfrent_end.getText();
	             
	             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	             
	             LocalDate rent_start2 = LocalDate.parse(rent_start, formatter);
	             LocalDate rent_end2 = LocalDate.parse(rent_end, formatter);
				
				resList = new ArrayList<ResVo>();
				ResVo vo2 = new ResVo();
				
				
				if((rent_start != null && rent_start.length() !=0) && (rent_end !=null && rent_end.length() !=0)){
					vo2.setRent_start(rent_start2);
					vo2.setRent_end(rent_end2);
					resList = resCon.searchRes(vo2);
					
					if(resList != null && resList.size() != 0) {
					loadTableData(resList);
					message("조회 성공");
					} else {
						loadTableData(null);
						message("조회 실패");
					}
				} 
				
			} else if(e.getSource()==btnMod) {
				rent_num = (String) memItems[row][0];
				rent_day1 = LocalDate.parse((String) memItems[row][1]);
				rent_start1 = LocalDate.parse((String) memItems[row][2]);
				rent_end1 = LocalDate.parse((String) memItems[row][3]);
				rent_car_num = (String) memItems[row][4];
				rent_id = (String) memItems[row][5];
				
				ResVo vo = new ResVo(rent_num, rent_day1, rent_start1, rent_end1, rent_car_num, rent_id);
				System.out.println("수정중");
				
				try {
					resCon.modRes(vo);
					message("수정 성공");
				} catch (Exception e2) {
					message("수정 실패");
				}
				
			} else if(e.getSource()==btnDel) {
				rent_num = (String) memItems[row][0];
				rent_day1 = LocalDate.parse((String) memItems[row][1]);
				rent_start1 = LocalDate.parse((String) memItems[row][2]);
				rent_end1 = LocalDate.parse((String) memItems[row][3]);
				rent_car_num = (String) memItems[row][4];
				rent_id = (String) memItems[row][5];
				
				ResVo vo = new ResVo(rent_num, rent_day1, rent_start1, rent_end1, rent_car_num, rent_id);
				System.out.println("삭제중");
				
				try {
					resCon.remRes(vo);
					message("삭제 성공");
				} catch (Exception e2) {
					message("삭제 실패");
				}
			} else if(e.getSource()==btnReg) {
				new ResRegDialog(resCon, "예약창");
				return;
			}
			
		}
		private void loadTableData (List<ResVo> resList) {
			if(resList!=null && resList.size() != 0) {
//				List<ResVo> list1 = new ArrayList<ResVo>();
				memItems = new String [resList.size()][6]; //리스트의 개수만큼 행을 설정
				for (int i =0; i<resList.size(); i++) {
					ResVo resVo = resList.get(i);
					memItems[i][0] = resVo.getRent_num();
					memItems[i][1] = resVo.getRent_day().toString();
			        memItems[i][2] = resVo.getRent_start().toString();
			        memItems[i][3] = resVo.getRent_end().toString();
					memItems[i][4] = resVo.getRent_car_num();
					memItems[i][5] = resVo.getRent_id();
				}
				//테이블 데이터 모델 설정
				rm = new RentTableModel2(memItems, columnNames);
				//테이블 UI view에 테이블 데이터 모델 설정
				table.setModel(rm);
				
			} else {
//				message("조회한 정보가 없습니다.");
				memItems = new Object[0][6];
				rm = new RentTableModel2(memItems, columnNames);
				table.setModel(rm);
			}
		}
		
	}
	public void message(String str) {
		JOptionPane.showMessageDialog(this, str,"메시지박스",JOptionPane.INFORMATION_MESSAGE);
	}
	
	class ListRowSel implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()) {
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				row = lsm.getMinSelectionIndex();
				System.out.println((row+1)+"행"+(row+1)+"열이 선택됨...");
			}
			
		}
	}
	class ListColSel implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			ListSelectionModel lsm = (ListSelectionModel)e.getSource();
			col = lsm.getMinSelectionIndex();
			if(!e.getValueIsAdjusting()) {
				System.out.println((row+1)+"행"+(col+1)+"열이 선택됨...");
			}
		}
	}
}

