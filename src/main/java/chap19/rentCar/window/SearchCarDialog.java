package chap19.rentCar.window;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import chap19.common.RentTableModel;
import chap19.rentCar.controller.CarController;
import chap19.rentCar.controller.CarControllerImpl;
import chap19.rentCar.vo.CarVo;

public class SearchCarDialog extends JDialog{
	JPanel panel, panelBtn;
	JLabel lCar_num;
	JTextField tfCar_num;
	JButton btnReg, btnModify, btnDelete, btnSearch;
	
	JTable carTable;
	
	String[] columnNames = {
			"차량 번호",
			"차량 이름",
			"차량 색상",
			"차량 사이즈",
			"제조사"
	};
	
	Object [][] carItems = new String[0][5];
	int rowIdx =0, colIdx=0;
	
	CarController carCon = new CarControllerImpl();
	RentTableModel rm;
	
	public SearchCarDialog(CarController carC, String str) {
		this.carCon = carC;
		
		setTitle(str);
		
		init();
	}
	
	
	public void init() {
		carTable = new JTable();
		
		panel = new JPanel(new GridLayout());
		panelBtn = new JPanel();
		lCar_num = new JLabel("아이디");
		tfCar_num = new JTextField(20);
		
		btnReg = new JButton("등록");
		btnDelete = new JButton("삭제");
		btnModify = new JButton("수정");
		btnSearch = new JButton("조회");
		
		panel.add(lCar_num);
		panel.add(tfCar_num);
		panel.add(btnSearch);
		
		panelBtn.add(btnReg);
		panelBtn.add(btnDelete);
		panelBtn.add(btnModify);
		
		btnReg.addActionListener(new CarBtnHandler());
		btnDelete.addActionListener(new CarBtnHandler());
		btnModify.addActionListener(new CarBtnHandler());
		btnSearch.addActionListener(new CarBtnHandler());
		
		rm = new RentTableModel(carItems, columnNames);
		carTable.setModel(rm);
		
		ListSelectionModel rowSel = carTable.getSelectionModel();
		rowSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ListSelectionModel colSel = carTable.getColumnModel().getSelectionModel();
		colSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		rowSel.addListSelectionListener(new ListRowSel());
		colSel.addListSelectionListener(new ListColSel());
		
		add(panel,BorderLayout.NORTH);
		add(panelBtn,BorderLayout.SOUTH);
		add(new JScrollPane(carTable),BorderLayout.CENTER);
		
		setLocation(300,100);
		setSize(800,600);
		setModal(true); //항상 부모 창 위에 표시
		setVisible(true);
		
		
	}
	
	public void loadTableData (List<CarVo> carList) {
		if(carList!=null && carList.size()!=0) {
			List<CarVo> list1 = new ArrayList<CarVo>();
			carItems = new String [carList.size()][5];
			for (int i=0; i<carList.size(); i++) {
				CarVo carVo = carList.get(i);
				carItems[i][0]=carVo.getCar_num();
				carItems[i][1]=carVo.getCar_name();
				carItems[i][2]=carVo.getCar_color();
				carItems[i][3] = String.valueOf(carVo.getCar_size());
				carItems[i][4]=carVo.getCar_made();
			}
			
			rm = new RentTableModel(carItems, columnNames);
			carTable.setModel(rm);
		} else {
//			message("조회한 정보가 없습니다.");
			carItems = new Object[0][5];
			rm = new RentTableModel(carItems, columnNames);
			carTable.setModel(rm);
		}
	}
	
	private void message (String str) {
		JOptionPane.showMessageDialog(this, str,"메시지박스",JOptionPane.INFORMATION_MESSAGE);
	}
	
	class CarBtnHandler implements ActionListener {
		String car_num = null;
		String car_name = null;
		String car_color = null;
		int car_size = 0;
		String car_made = null;
		
		CarVo co1 = CarVo.builder()
				.car_num(car_num)
				.car_name(car_name)
				.car_color(car_color)
				.car_size(car_size)
				.car_made(car_made)
				.build();
		
		List<CarVo> carList = null;
		

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnReg) {
				new RegCarDialog(carCon, "차량 등록창");
				return;
			} else if(e.getSource()==btnModify) {
				car_num = (String) carItems[rowIdx][0];
				car_name = (String) carItems[rowIdx][1];
				car_color = (String) carItems[rowIdx][2];
				car_size = Integer.parseInt((String) carItems[rowIdx][3]);
				car_made = (String) carItems[rowIdx][4];
				
				CarVo vo = new CarVo(car_num, car_name, car_color, car_size, car_made);
				System.out.println("수정중"+vo);
				
				try {
					carCon.modCar(vo);
					message("수정 성공");
				} catch (Exception e1) {
					message("수정 실패");
				}
				
			} else if (e.getSource()==btnDelete) {
				car_num = (String) carItems[rowIdx][0];
				car_name = (String) carItems[rowIdx][1];
				car_color = (String) carItems[rowIdx][2];
				car_size = Integer.parseInt((String) carItems[rowIdx][3]);
				car_made = (String) carItems[rowIdx][4];
				
				CarVo vo = new CarVo(car_num, car_name, car_color, car_size, car_made);
				System.out.println("삭제중"+vo);
				
				try {
					carCon.removeCar(vo);
					message("삭제 성공");
				} catch (Exception e2) {
					message("삭제 실패");
				}
			} else if(e.getSource()==btnSearch) {
				String name = tfCar_num.getText().trim();
				
				carList = new ArrayList<CarVo>();
				CarVo vo2 = new CarVo();
				
				if(name!= null && name.length()!=0) {
					vo2.setCar_name(name);
					
					carList = carCon.listCar(vo2);
					if(carList != null && carList.size() !=0) {
						loadTableData(carList);
						message("이름으로 조회 성공");
					} else {
						loadTableData(null);
						message("잘못 입력하셨습니다.");
						
					}
				} else {
					carList = carCon.listCar(vo2);
					loadTableData(carList);
					message("전체 조회 성공");
				}
			}
			
		}
		
	}
	
	class ListRowSel implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()) {
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				rowIdx = lsm.getMinSelectionIndex();
				System.out.println((rowIdx+1)+"행"+(colIdx+1)+"열이 선택됨...");
			}
			
		}
	}
	class ListColSel implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			ListSelectionModel lsm = (ListSelectionModel)e.getSource();
			colIdx = lsm.getMinSelectionIndex();
			if(!e.getValueIsAdjusting()) {
				System.out.println((rowIdx+1)+"행"+(colIdx+1)+"열이 선택됨...");
			}
		}
		
	}
}
