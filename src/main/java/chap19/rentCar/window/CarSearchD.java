package chap19.rentCar.window;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import chap19.common.RentTableModel;
import chap19.rentCar.controller.CarController;
import chap19.rentCar.controller.CarControllerImpl;

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
	
	public CarSearchD(CarController carC, String str, String str2) {
		this.carCon = carC;
		setTitle(str);
		System.out.println("===str2");
		
		init();
	}
	
	
	private void init() {
		carTable = new JTable();
		
		rm = new RentTableModel(carItems, columnNames);
		add(new JScrollPane(carTable),BorderLayout.CENTER);
		
		setLocation(300,100);
		setSize(800,600);
		setModal(true); //항상 부모 창 위에 표시
		setVisible(true);
		
	}
}
