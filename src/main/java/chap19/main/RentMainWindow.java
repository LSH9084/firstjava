package chap19.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.apache.logging.log4j.message.Message;

import chap19.common.RentTableModel;
import chap19.common.base.AbstactBaseWindow;
import chap19.member.controller.MemberController;
import chap19.member.controller.MemberControllerImpl;
import chap19.member.window.RegMemDialog;
import chap19.member.window.RemoveMemDialog;
import chap19.member.window.SearchMemDialog;
import chap19.member.window.UpdateMemDialog;
import chap19.rentCar.controller.CarController;
import chap19.rentCar.controller.CarControllerImpl;
import chap19.rentCar.vo.CarVo;
import chap19.rentCar.window.CarSearchColor;
import chap19.rentCar.window.CarSearchD;
import chap19.rentCar.window.CarSearchMade;
import chap19.rentCar.window.CarSearchNum;
import chap19.rentCar.window.ModCarDialog;
import chap19.rentCar.window.RegCarDialog;
import chap19.rentCar.window.RemoveCarDialog;
import chap19.rentCar.window.SearchCarDialog;
import chap19.res.controller.ResController;
import chap19.res.controller.ResControllerImpl;
import chap19.res.dao.ResDaoImpl;
import chap19.res.window.ResModDialog;
import chap19.res.window.ResRegDialog;
import chap19.res.window.ResRemoveDialog;
import chap19.res.window.ResSearchiDialog;

public class RentMainWindow extends AbstactBaseWindow {
	JFrame frm;
	JMenuBar menuBar;
	JMenu carMenu, memberMenu, resMenu, helpMenu;
	JMenuItem carMenu11, carMenu12, carMenu13, carMenu14;
	JMenuItem memMenu21, memMenu22, memMenu23, memMenu24;
	JMenuItem resMenu31, resMenu32, resMenu33, resMenu34;
	JMenuItem helpMenu41;
	
	JPanel panel;
	JLabel lCarName;
	JTextField tf;
	JButton btnSearch;
	JComboBox comboBox; //검색 조건 설정
	CarController carControll = new CarControllerImpl();
	MemberController memControll = new MemberControllerImpl();
	ResController resControll = new ResControllerImpl();
//	JTable carTable;
//	String[] columnNames = {
//			"차량 번호",
//			"차량 이름",
//			"차량 색상",
//			"차량 사이즈",
//			"제조사"
//	};
//	Object [][] carItems = new String[0][5];
//	int rowIdx =0, colIdx=0;
//	RentTableModel rm;
public RentMainWindow() {
		setTitle("렌트카 조회/예약 시스템");
		
		menuBar = new JMenuBar();
		carMenu = new JMenu("car");
		memberMenu = new JMenu("member");
		resMenu = new JMenu("res");
		helpMenu = new JMenu("help");
		
		
		
		startFrame();
	}
	
	protected void startFrame() {
		setJMenuBar(menuBar);
		menuBar.add(memberMenu);
		memberMenu.add(memMenu21= new JMenuItem("회원 등록"));
		memberMenu.add(memMenu22= new JMenuItem("회원 조회"));
		memberMenu.addSeparator();
		memberMenu.add(memMenu23= new JMenuItem("회원 수정"));
		memberMenu.add(memMenu24= new JMenuItem("회원 삭제"));
		menuBar.add(carMenu);
		carMenu.add(carMenu11= new JMenuItem("차량 등록"));
		carMenu.add(carMenu12= new JMenuItem("차량 조회"));
		carMenu.addSeparator();
		carMenu.add(carMenu13= new JMenuItem("차량 수정"));
		carMenu.add(carMenu14= new JMenuItem("차량 삭제"));
		menuBar.add(resMenu);
		resMenu.add(resMenu31= new JMenuItem("예약 등록"));
		resMenu.add(resMenu32= new JMenuItem("예약 조회"));
		resMenu.addSeparator();
		resMenu.add(resMenu33= new JMenuItem("예약 수정"));
		resMenu.add(resMenu34= new JMenuItem("예약 삭제"));
		menuBar.add(helpMenu);
		helpMenu.add(helpMenu41= new JMenuItem("도움말"));
		
//		setJMenuBar(menuBar);
		
		panel = new JPanel();
		lCarName = new JLabel("차량번호");
		tf = new JTextField(10);
		
		comboBox = new JComboBox();
		comboBox.addItem("차량번호");
		comboBox.addItem("차량색상");
		comboBox.addItem("배기량");
		comboBox.addItem("제조사");
		comboBox.addItem("차량이름");
		
		btnSearch = new JButton("차량 조회하기");
		
//		carTable = new JTable();
//		rm = new RentTableModel(carItems, columnNames);
//		carTable.setModel(rm);
		
		
		
//		add(new JScrollPane(carTable), BorderLayout.CENTER);
		

			
		
		panel.add(lCarName);
		panel.add(tf);
		panel.add(comboBox);
		panel.add(btnSearch);
		
		
		Container con = getContentPane();
		con.add(panel, BorderLayout.NORTH);
		
		con.add(btnSearch,BorderLayout.SOUTH);
		
		setLocation(200,200);
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		memMenu21.addActionListener(new MemberHandler());
		memMenu22.addActionListener(new MemberHandler());
		memMenu23.addActionListener(new MemberHandler());
		memMenu24.addActionListener(new MemberHandler());
		carMenu11.addActionListener(new MemberHandler());
		carMenu14.addActionListener(new MemberHandler());
		carMenu13.addActionListener(new MemberHandler());
		carMenu12.addActionListener(new MemberHandler());
		btnSearch.addActionListener(new MemberHandler());
		resMenu31.addActionListener(new MemberHandler());
		resMenu33.addActionListener(new MemberHandler());
		resMenu34.addActionListener(new MemberHandler());
		resMenu32.addActionListener(new MemberHandler());
		helpMenu41.addActionListener(new MemberHandler());
	}
	
	public static void main(String[] args) {
		RentMainWindow rm = new RentMainWindow();
		
	}
	
	class MemberHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			try {
				System.out.println(e.getActionCommand());
				if(e.getSource()==memMenu21) {
					new RegMemDialog(memControll, "회원 등록창");
				} else if(e.getSource()==memMenu24) {
					new RemoveMemDialog(memControll, "회원 삭제창");
				} else if(e.getSource()==memMenu23) {
					new UpdateMemDialog(memControll, "회원 정보 수정");
				} else if(e.getSource()==carMenu11) {
					new RegCarDialog(carControll, "차량 등록 창");
				} else if(e.getSource()==carMenu14) {
					new RemoveCarDialog(carControll,"차량 삭제 창");
				} else if(e.getSource()==carMenu13) {
					new ModCarDialog(carControll, "차량 정보 수정");
				} else if(e.getSource()==memMenu22) {
					new SearchMemDialog(memControll, "조회창");
				} else if(e.getSource()==carMenu12) {
					new SearchCarDialog(carControll, "조회창");
				} else if(e.getSource()==btnSearch && comboBox.getSelectedItem().equals("차량이름") ) {
					String iii = tf.getText().trim();
					new CarSearchD(carControll, "car_name조회",iii);
					
				} else if(e.getSource()==btnSearch && comboBox.getSelectedItem().equals("차량번호")) {
					String iii = tf.getText().trim();
					String com = comboBox.getSelectedItem().toString();
					System.out.println(com);
					new CarSearchNum(carControll, "car_num조회", iii);
				} else if(e.getSource()==btnSearch && comboBox.getSelectedItem().equals("차량색상")) {
					String iii = tf.getText().trim();
					new CarSearchColor(carControll, "car_color조회", iii);
				} else if(e.getSource()==btnSearch && comboBox.getSelectedItem().equals("제조사")) {
					String iii = tf.getText().trim();
					new CarSearchMade(carControll, "car_color조회", iii);
				} else if(e.getSource()== resMenu31) {
					new ResRegDialog(resControll, "렌트등록");
				} else if(e.getSource()== resMenu33) {
					new ResModDialog(resControll, "렌트수정");
				} else if(e.getSource()==resMenu34) {
					new ResRemoveDialog(resControll, "렌트삭제");
				} else if(e.getSource()==resMenu32) {
					new ResSearchiDialog(resControll, "렌트조회");
				} else if(e.getSource()==helpMenu41) {
					System.out.println("도움말 창은 만들기가 너무 귀찮아서 패스함");
				}
				
			} catch (Exception e2) {}
		}
	}
	
//	public void loadTableData (List<CarVo> carList) {
//		if(carList!=null && carList.size()!=0) {
//			List<CarVo> list1 = new ArrayList<CarVo>();
//			carItems = new String [carList.size()][5];
//			for (int i=0; i<carList.size(); i++) {
//				CarVo carVo = carList.get(i);
//				carItems[i][0]=carVo.getCar_num();
//				carItems[i][1]=carVo.getCar_name();
//				carItems[i][2]=carVo.getCar_color();
//				carItems[i][3] = String.valueOf(carVo.getCar_size());
//				carItems[i][4]=carVo.getCar_made();
//			}
//			
//			rm = new RentTableModel(carItems, columnNames);
//			carTable.setModel(rm);
//		} else {
////			message("조회한 정보가 없습니다.");
//			carItems = new Object[0][5];
//			rm = new RentTableModel(carItems, columnNames);
//			carTable.setModel(rm);
//		}
//	}
	
//	comboBox.addActionListener(new ActionListener() {
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(comboBox.getSelectedItem().equals("차량번호")) {
//			
//		} else if(comboBox.getSelectedItem().equals("차량색상")) {
//			
//		}else if(comboBox.getSelectedItem().equals("배기량")) {
//			
//		}else if(comboBox.getSelectedItem().equals("제조사")) {
//			
//		}else if(comboBox.getSelectedItem().equals("차량이름")) {
//			btnSearch.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					SearchCarDialog scd = new SearchCarDialog();
//					List<CarVo> list1 = new ArrayList<CarVo>();
//					String name = tf.getText().trim();
//					CarVo vo2 = new CarVo();
//					System.out.println("===");
//					if(name!= null && name.length() !=0) {
//						vo2.setCar_name(name);
//						list1 = carControll.listCar(vo2);
//						if(list1 != null && list1.size() !=0) {
//							scd.loadTableData(list1);
//						} else {
//							scd.loadTableData(null);
//							
//							
//						}
//					} else {
//						list1 = carControll.listCar(vo2);
//						scd.loadTableData(list1);
//						
//					}
//					
//				}
//			});
//		}
//		
//	}
//});
}
