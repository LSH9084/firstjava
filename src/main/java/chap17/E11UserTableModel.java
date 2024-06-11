package chap17;

import javax.swing.table.AbstractTableModel;

public class E11UserTableModel extends AbstractTableModel {
	String [] columnNames = {"사번","이름","근무부서"};
	Object [][] data = {
			{"","",""}
	};
	
	boolean [] columnEditables = new boolean[] {false, true, true};
	
	public E11UserTableModel(Object[][] data) {
		this.data = data;
	}
	

	@Override
	public int getRowCount() {
		//테이블의 행의 수를 지정
		return data.length; //2차원 함수면 2차원의 길이만 3차원 함수면 3차원의 길이만을 판별한다.
	}

	@Override
	public int getColumnCount() {
		//테이블의 열의 수를 지정
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//각 셀의 값
		return data[rowIndex][columnIndex];
	}
	
	//각 컬럼명
	public String getColumnName(int rowIndex) {
		return columnNames[rowIndex];
	}
	//각 셀의 편집 기능 여부 지정
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnEditables[columnIndex];
		
	}
	
	//셀의 데이터 수정시 수정된 데이터를 반영
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = value;
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	
	public static void main(String[] args) {
		
		
	}
}
