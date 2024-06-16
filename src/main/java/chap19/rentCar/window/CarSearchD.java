package chap19.rentCar.window;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import chap19.common.RentTableModel;
import chap19.member.controller.MemberController;
import chap19.member.controller.MemberControllerImpl;
import chap19.rentCar.controller.CarController;
import chap19.rentCar.controller.CarControllerImpl;
import chap19.rentCar.vo.CarVo;

public class CarSearchD extends JDialog{
	JTable carTable;
	String[] columnNames = {
			"차량 번호",
			"차량 이름",
			"차량 색상",
			"차량 사이즈",
			"제조사"
	};
	Object [][] carItems = new String[0][5];
	CarController carCon = new CarControllerImpl();
	RentTableModel rm;
	String iii;
	public CarSearchD(CarController carC, String str, String str2) {
		this.carCon = carC;
		setTitle(str);
		this.iii = str2;
		System.out.println(iii);
		
//		init();
		carTable = new JTable();
		
		rm = new RentTableModel(carItems, columnNames);
		carTable.setModel(rm);
		init2 ini = new init2();
	}
	

	public class init2{
		String car_num = null;
		String car_name = null;
		String car_color = null;
		int car_size = 0;
		String car_made = null;
		CarController carcon = new CarControllerImpl();
		
		CarVo vo1 = CarVo.builder()
				.car_num(car_num)
				.car_name(car_name)
				.car_color(car_color)
				.car_size(car_size)
				.car_made(car_made)
				.build();
		
		List<CarVo> carList = null;
		
		
		public init2() {
			CarVo vo2 = new CarVo();
			String name = iii;
			if(name !=null && name.length() !=0) {
				vo2.setCar_name(name);
				carList = carcon.listCar(vo2);
			
				if(carList != null && carList.size() !=0) {
					loadTableData(carList);
				}
			} else {
				carList = carcon.listCar(vo2);
				loadTableData(carList);
			}
			
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
				init();
			} else {
//				message("조회한 정보가 없습니다.");
				carItems = new Object[0][5];
				rm = new RentTableModel(carItems, columnNames);
				carTable.setModel(rm);
				init();
			}
		}
		}
	
	
	
	
	private void init() {
		
		add(new JScrollPane(carTable),BorderLayout.CENTER);
		
		setLocation(300,100);
		setSize(800,600);
		setModal(true); //항상 부모 창 위에 표시
		setVisible(true);
		
//		init2 ini = new init2();
		
	}
	
}
