package chap19.common;
import javax.swing.table.AbstractTableModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RentTableModel2 extends AbstractTableModel{
	
	
	Object [][] memItems ;
	String [] columnNames ;
	boolean [] columnEditables = new boolean[] {false, true, true, true, false, false};
	
	public RentTableModel2(Object [][] data ,String []column) {
		this.memItems = data;
		this.columnNames = column;
	}
	

	@Override
	public int getRowCount() {
		return memItems.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return memItems[rowIndex][columnIndex];
	}
	
	public String getColumnName(int rowIndex) {
		return columnNames[rowIndex];
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnEditables[columnIndex];
	}
	
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		memItems[rowIndex][columnIndex] = value;
		fireTableCellUpdated(rowIndex, columnIndex);
	}
		
	
	
}
